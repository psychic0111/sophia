package com.yz.sophia.bsf.core.base.model;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yz.sophia.bsf.core.base.exception.BizException;

/**
 * Created by yanglikai on 2019/5/28.
 */
public abstract class GeneralRequest extends GeneralObject {

  public <T> T tDO(Class<? extends GeneralObject> target) {
    return map(target);
  }

  public EntityWrapper tEntityWrapper() {
    throw new BizException("tEntityWrapper未实现");
  }
}
