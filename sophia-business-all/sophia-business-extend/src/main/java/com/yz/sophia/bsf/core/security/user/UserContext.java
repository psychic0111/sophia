package com.yz.sophia.bsf.core.security.user;

/**
 * Created by yanglikai on 2019/4/16.
 */
public final class UserContext {

  private UserContext() {
  }

  private static final ThreadLocal<SecurityUser> context = new ThreadLocal<>();

  public static void set(SecurityUser target) {
    context.set(target);
  }

  public static SecurityUser getUser() {
    return context.get();
  }

  public static void clear() {
    context.remove();
  }
}
