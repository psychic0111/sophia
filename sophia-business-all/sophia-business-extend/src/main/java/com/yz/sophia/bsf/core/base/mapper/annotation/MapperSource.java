package com.yz.sophia.bsf.core.base.mapper.annotation;

import java.lang.annotation.*;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MapperSource {

  Class<?> value();
}
