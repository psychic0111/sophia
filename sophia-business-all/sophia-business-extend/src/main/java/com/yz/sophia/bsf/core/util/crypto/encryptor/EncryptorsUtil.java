package com.yz.sophia.bsf.core.util.crypto.encryptor;


import com.yz.sophia.bsf.core.util.crypto.hash.Md5DigestUtil;
import com.yz.sophia.bsf.core.util.crypto.hash.Sha256DigestUtil;
import com.yz.sophia.bsf.core.util.crypto.hash.Sha512DigestUtil;
import com.yz.sophia.bsf.core.util.crypto.hash.SlowEqualsUtil;
import com.yz.sophia.bsf.core.util.crypto.keygen.KeyGeneratorUtil;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class EncryptorsUtil {

  private EncryptorsUtil() {
  }

  public static String md5(String target) {
    return Md5DigestUtil.md5Hex(target);
  }

  public static String sha256(String target) {
    return Sha256DigestUtil.shaHex(target);
  }

  public static String sha512(String target) {
    return Sha512DigestUtil.shaHex(target);
  }

  public static boolean slowEquals(String arg1, String arg2) {
    return SlowEqualsUtil.slowEquals(arg1.getBytes(), arg2.getBytes());
  }

  public static String generateKey() {
    return KeyGeneratorUtil.generateKey();
  }
}
