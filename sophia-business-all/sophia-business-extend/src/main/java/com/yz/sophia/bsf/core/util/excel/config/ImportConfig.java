package com.yz.sophia.bsf.core.util.excel.config;

import com.yz.sophia.bsf.core.util.excel.annotation.ImportField;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yanglikai on 2019/5/28.
 */
public class ImportConfig {

  private InputStream stream;
  private Class target;
  private Map<Integer, ImportField> maps;

  public ImportConfig(Class target) {
    this.target = target;

    init();
  }

  public ImportConfig config(InputStream inputStream) {
    this.stream = inputStream;
    return this;
  }

  private void init() {
    maps = new HashMap<>();

    Field[] fields = target.getDeclaredFields();
    for (Field field : fields) {
      ImportField annotation = field.getAnnotation(ImportField.class);
      if (annotation == null) {
        continue;
      }

      maps.put(annotation.index(), annotation);
    }
  }

  public ImportField field(int index) {
    return maps.getOrDefault(index, null);
  }

  public InputStream stream() {
    Objects.requireNonNull(stream, "InputStream must be not null");
    return stream;
  }

  public Class getTarget() {
    return target;
  }
}
