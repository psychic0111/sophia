package com.yz.sophia.business.core.util;

import com.alibaba.fastjson.JSON;
import com.yz.sophia.bsf.core.base.BsfException;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 对象处理工具集
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
    private static Map<Class, Boolean> complexClasses = new ConcurrentHashMap<>();


    private static void setObjectValue(Object dest, String name, Object value, boolean throwOnFail) {
        try {
            PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(dest, name);
            if (descriptor == null) {
                return;
            }
            Method writeMethod = descriptor.getWriteMethod();
            if (writeMethod == null) {
                return;
            }
            writeMethod.invoke(dest, value);
        } catch (Exception e) {
            if (throwOnFail) {
                if (e instanceof InvocationTargetException) {
                    Throwable te = ((InvocationTargetException) e).getTargetException();
                    if (te != null && te instanceof BsfException) {
                        throw (BsfException) te;
                    }
                }
                throw new BsfException("set property failed: " + name + "=" + value, e);
            }
        }
    }


    public static void setProperties(Object dest, Object orig, boolean ignoreNull, boolean throwOnFail) {
        if (orig instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) orig;
            map.forEach((name, value) -> {
                if (!ignoreNull || value != null) {
                    setObjectValue(dest, name, value, throwOnFail);
                }
            });
        } else {
            PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(orig.getClass());
            for (PropertyDescriptor descriptor : descriptors) {
                Method method = descriptor.getReadMethod();
                if (method == null || method.getDeclaringClass() == Object.class) {
                    continue;
                }
                String name = descriptor.getName();
                Object value;
                try {
                    value = method.invoke(orig);
                } catch (Exception e) {
                    if (throwOnFail) {
                        throw new BsfException("read property failed: " + name, e);
                    } else {
                        continue;
                    }
                }
                if (!ignoreNull || value != null) {
                    setObjectValue(dest, name, value, throwOnFail);
                }
            }
        }
    }

    public static void setProperties(Object dest, Object orig, boolean ignoreNull) {
        setProperties(dest, orig, ignoreNull, false);
    }

    public static <R, T> R convert(Class<R> clazz, T obj, Consumer<R> consumer) {
        if (obj == null) return null;
        Boolean complex = complexClasses.get(clazz);
        if (complex == null) {
            PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
            if (descriptors != null && descriptors.length > 0) {
                for (PropertyDescriptor descriptor : descriptors) {
                    Class<?> type = descriptor.getPropertyType();
                    if (Map.class.isAssignableFrom(type) || Collection.class.isAssignableFrom(type) || type.isArray()) {
                        complex = true;
                        break;
                    }
                }
            }
            if (complex == null) complex = false;
            complexClasses.put(clazz, complex);
        }
        R dest;
        if (complex) {
            dest = JSON.parseObject(JSON.toJSONString(obj), clazz);
        } else {
            try {
                dest = clazz.newInstance();
            } catch (Exception e) {
                throw new BsfException("create instance failed: " + e.getMessage(), e);
            }
            setProperties(dest, obj, true, true);
        }
        if (consumer != null) {
            consumer.accept(dest);
        }
        return dest;
    }

    public static <R, T> R convert(Class<R> clazz, T obj) {
        return convert(clazz, obj, null);
    }

    public static <R, T> List<R> convertList(Class<R> clazz, List<T> objList, BiConsumer<T, R> consumer) {
        return objList.stream().map(o -> convert(clazz, o, r-> consumer.accept(o, r))).collect(Collectors.toList());
    }

    public static <R, T> List<R> convertList(Class<R> clazz, List<T> objList, Consumer<R> consumer) {
        return objList.stream().map(o -> convert(clazz, o, consumer)).collect(Collectors.toList());
    }

    public static <R, T> List<R> convertList(Class<R> clazz, List<T> objList) {
        return objList.stream().map(o -> convert(clazz, o, null)).collect(Collectors.toList());
    }

}
