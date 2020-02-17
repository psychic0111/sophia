package com.yz.sophia.insight.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.lang3.StringUtils;

public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static String DEFAULT_PRIVATE_KEY_FILE = "/rsa/pkcs8_rsa_private_key.pem";
    private static String DEFAULT_PUBLIC_KEY_FILE = "/rsa/rsa_public_key.pem";
    private static String defaultPrivateKey = null;
    private static String defaultPublicKey = null;

    public RSAUtils() {
    }

    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap(2);
        keyMap.put("RSAPublicKey", publicKey);
        keyMap.put("RSAPrivateKey", privateKey);
        return keyMap;
    }

    public static String sign(byte[] data, String privateKey) throws Exception {
        privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encode(signature.sign());
    }

    public static String sign(byte[] data) throws Exception {
        return sign(data, getDefaultPrivateKey());
    }

    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decode(sign));
    }

    public static boolean verify(byte[] data, String sign) throws Exception {
        return verify(data, getDefaultPublicKey(), sign);
    }

    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
        privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 128) {
            byte[] cache;
            if (inputLen - offSet > 128) {
                cache = cipher.doFinal(encryptedData, offSet, 128);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public static byte[] decryptByPrivateKey(byte[] encryptedData) throws Exception {
        return decryptByPrivateKey(encryptedData, getDefaultPrivateKey());
    }

    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 128) {
            byte[] cache;
            if (inputLen - offSet > 128) {
                cache = cipher.doFinal(encryptedData, offSet, 128);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public static byte[] decryptByPublicKey(byte[] encryptedData) throws Exception {
        return decryptByPublicKey(encryptedData, getDefaultPublicKey());
    }

    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
            byte[] cache;
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static byte[] encryptByPublicKey(byte[] data) throws Exception {
        return encryptByPublicKey(data, getDefaultPublicKey());
    }

    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
            byte[] cache;
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static byte[] encryptByPrivateKey(byte[] data) throws Exception {
        return encryptByPrivateKey(data, getDefaultPrivateKey());
    }

    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key)keyMap.get("RSAPrivateKey");
        return Base64.encode(key.getEncoded());
    }

    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key)keyMap.get("RSAPublicKey");
        return Base64.encode(key.getEncoded());
    }

    public static String readKey(String rsaKey) throws Exception {
        if (StringUtils.isEmpty(rsaKey)) {
            return null;
        } else {
            String regex = "((\\-).*?((\r\n)|\n))|((\\-).*?\\-$)";
            return rsaKey.replaceAll(regex, "").trim();
        }
    }

    public static String readKeyFile(File file) throws Exception {
        return readKeyFile((InputStream)(new FileInputStream(file)));
    }

    public static String readKeyFile(InputStream in) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readLine = null;
        StringBuilder sb = new StringBuilder();

        while((readLine = br.readLine()) != null) {
            if (readLine.charAt(0) != '-') {
                sb.append(readLine);
                sb.append('\r');
            }
        }

        if (br != null) {
            br.close();
        }

        return sb.toString();
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static String getDefaultPrivateKey() throws Exception {
        if (defaultPrivateKey == null) {
            defaultPrivateKey = readKeyFile(RSAUtils.class.getResourceAsStream(DEFAULT_PRIVATE_KEY_FILE));
        }

        return defaultPrivateKey;
    }

    public static String getDefaultPublicKey() throws Exception {
        if (defaultPublicKey == null) {
            defaultPublicKey = readKeyFile(RSAUtils.class.getResourceAsStream(DEFAULT_PUBLIC_KEY_FILE));
        }

        return defaultPublicKey;
    }

    public static void main(String[] args) throws Exception {
        test1024();
    }

    public static void test1024() throws Exception {
        String srcText = "&emotion=&endTime=2019-09-18&pageIndex=1&pageRows=1&sourceType=[1]&startTime=2019-09-18";
        String rsaPrivateKey = readKeyFile(RSAUtils.class.getResourceAsStream("/rsa/pkcs8_rsa_private_key.pem"));
        String rsaPublicKey = readKeyFile(RSAUtils.class.getResourceAsStream("/rsa/rsa_public_key.pem"));
        String sign = sign(srcText.getBytes(), rsaPrivateKey);
        System.err.println("The private key signature:\r" + sign);
        boolean status = verify(srcText.getBytes(), rsaPublicKey, sign);
        System.err.println("Public key verification results:\r" + status);
    }
}
