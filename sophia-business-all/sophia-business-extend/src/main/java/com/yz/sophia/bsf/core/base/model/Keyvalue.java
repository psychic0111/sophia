package com.yz.sophia.bsf.core.base.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Data
public class Keyvalue implements Serializable {

  private String key;

  private String value;

  public Keyvalue() {
  }

  public Keyvalue(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String format() {
    return format(":");
  }

  public String format(String separator) {
    return key + separator + value;
  }
}
