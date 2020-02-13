package com.yz.sophia.bsf.core.util.crypto.keygen;

import com.yz.sophia.bsf.core.util.crypto.codec.Hex;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class KeyGeneratorUtil {

  private KeyGeneratorUtil() {
  }

  public static String generateKey() {
    return generateKey(32);
  }

  public static String generateKey(int keyLength) {
    return
        new String(Hex.encode(KeyGenerators.secureRandom(keyLength).generateKey()));
  }
}
