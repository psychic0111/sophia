package com.yz.sophia.bsf.core.util.excel.annotation;

import java.lang.annotation.*;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ExportField {
  /**
   * 索引(从0开始).
   *
   * @return
   */
  int index();

  /**
   * 标题.
   *
   * @return
   */
  String title() default "";

  /**
   * 字段名称.
   *
   * @return
   */
  String name();
}
