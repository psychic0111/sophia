package com.yz.sophia.bsf.core.util.crypto.hash;

import com.yz.sophia.bsf.core.util.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class Sha256DigestUtil {

  private Sha256DigestUtil() {
  }

  private static MessageDigest getSha256Digest() {
    try {
      return MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static byte[] sha(byte[] data) {
    return getSha256Digest().digest(data);
  }

  public static byte[] sha(String data) {
    return sha(data.getBytes());
  }

  public static String shaHex(byte[] data) {
    return new String(Hex.encode(sha(data)));
  }

  public static String shaHex(String data) {
    return new String(Hex.encode(sha(data)));
  }
}
