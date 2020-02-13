package com.yz.sophia.bsf.core.base.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Data
public class PageResponse<T> implements Serializable {

  private long total;

  private int size;

  private int current;

  private long pages;

  private List<T> list;
}
