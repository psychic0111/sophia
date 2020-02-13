package com.yz.sophia.bsf.core.util.crypto.hash;

import com.yz.sophia.bsf.core.util.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class Md5DigestUtil {

  private Md5DigestUtil() {
  }

  private static MessageDigest getMd5Digest() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static byte[] md5(byte[] data) {
    return getMd5Digest().digest(data);
  }

  public static byte[] md5(String data) {
    return md5(data.getBytes());
  }

  public static String md5Hex(byte[] data) {
    return new String(Hex.encode(md5(data)));
  }

  public static String md5Hex(String data) {
    return new String(Hex.encode(md5(data)));
  }
}
