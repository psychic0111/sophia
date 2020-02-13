package com.yz.sophia.bsf.core.base.mapper;

import com.yz.sophia.bsf.core.base.model.GeneralObject;

import java.util.List;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class MapperList {
  private List source;

  private MapperList(List source) {
    this.source = source;
  }

  public static MapperList wrap(List source) {
    return new MapperList(source);
  }

  public <E> List<E> tDTO(Class<? extends GeneralObject> target) {
    return tMap(target);
  }

  public <E> List<E> tVO(Class<? extends GeneralObject> target) {
    return tMap(target);
  }

  public <E> List<E> tRequest(Class<? extends GeneralObject> target) {
    return tMap(target);
  }

  public <E> List<E> tResponse(Class<? extends GeneralObject> target) {
    return tMap(target);
  }

  public <E> List<E> tDO(Class<? extends GeneralObject> target) {
    return tMap(target);
  }

  private <E> List<E> tMap(Class<? extends GeneralObject> target) {
    return Mapper.map(source, target);
  }
}
