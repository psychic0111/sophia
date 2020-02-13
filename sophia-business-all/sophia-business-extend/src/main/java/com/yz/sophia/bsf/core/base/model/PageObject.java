package com.yz.sophia.bsf.core.base.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yz.sophia.bsf.core.base.constant.GlobalManager;
import lombok.Data;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Data
public abstract class PageObject extends RootObject {

  @JsonIgnore
  @TableField(exist = false)
  private Integer page;

  @JsonIgnore
  @TableField(exist = false)
  private Integer size;

  public int current() {
    return page == null ? 1 : page;
  }

  public int size() {
    return size == null ? GlobalManager.DEFAULT_PAGE_SIZE : size;
  }

  @JsonIgnore
  public int getLimit() {
    return size();
  }

  @JsonIgnore
  public int getOffset() {
    return (current() - 1) * size();
  }

  public Page tPage() {
    return new Page<>(current(), size());
  }
}
