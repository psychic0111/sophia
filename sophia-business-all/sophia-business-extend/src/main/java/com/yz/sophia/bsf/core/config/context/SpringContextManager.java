package com.yz.sophia.bsf.core.config.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2019/5/28.
 */
@Component
public class SpringContextManager implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    SpringContextManager.applicationContext = applicationContext;
  }

  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  public static String getApplicationName() {
    return applicationContext.getApplicationName();
  }
}
