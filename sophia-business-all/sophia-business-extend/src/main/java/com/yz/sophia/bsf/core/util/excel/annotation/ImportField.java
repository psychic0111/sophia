package com.yz.sophia.bsf.core.util.excel.annotation;

import java.lang.annotation.*;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ImportField {

  /**
   * 索引(从0开始).
   */
  int index();

  /**
   * 描述.
   */
  String desc() default "";

  /**
   * 字段名称.
   */
  String name();

  /**
   * 字段类型.
   */
  Class type();
}
