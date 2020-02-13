package com.yz.sophia.bsf.core.util.crypto.hash;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class SlowEqualsUtil {

  private SlowEqualsUtil() {
  }

  public static boolean slowEquals(byte[] arg1, byte[] arg2) {
    int diff = arg1.length ^ arg2.length;
    for (int i = 0; i < arg1.length && i < arg2.length; i++) {
      diff |= arg1[i] ^ arg2[i];
    }

    return diff == 0;
  }
}
