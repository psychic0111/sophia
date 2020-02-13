package com.yz.sophia.bsf.core.config.collector;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Slf4j
public final class ExceptionLogCollector {

  private ExceptionLogCollector() {
  }

  public static void collect(Throwable t) {
    log.error(t.getMessage(), t);
  }

  public static void collect(String format, Object arg1, Object arg2) {
    log.error(format, arg1, arg2);
  }
}
