package com.yz.sophia.bsf.core.base.mapper.annotation;

import java.lang.annotation.*;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface MapperProperty {

  String[] value() default {};
}
