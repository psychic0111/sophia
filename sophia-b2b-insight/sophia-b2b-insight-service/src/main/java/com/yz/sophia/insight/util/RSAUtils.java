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
  
    public static Map<String, Object> genKeyPair() throws Exception {  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);  
        keyPairGen.initialize(1024);  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
        Map<String, Object> keyMap = new HashMap<String, Object>(2);  
        keyMap.put(PUBLIC_KEY, publicKey);  
        keyMap.put(PRIVATE_KEY, privateKey);  
        return keyMap;  
    }  
      
    public static String sign(byte[] data, String privateKey) throws Exception {  
    	privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(privateK);  
        signature.update(data);  
        return Base64.encode(signature.sign());
    }  
    
    public static String sign(byte[] data) throws Exception {
    	return sign(data, getDefaultPrivateKey());
    }
  
    public static boolean verify(byte[] data, String publicKey, String sign)  
            throws Exception {  
    	publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        PublicKey publicK = keyFactory.generatePublic(keySpec);  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(publicK);  
        signature.update(data);  
        return signature.verify(Base64.decode(sign));  
    }  
    
    public static boolean verify(byte[] data,String sign)  throws Exception {
    	return verify(data, getDefaultPublicKey(), sign);
    }
  
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)  
            throws Exception {  
    	privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateK);  
        int inputLen = encryptedData.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_DECRYPT_BLOCK;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return decryptedData;  
    }  
    
    public static byte[] decryptByPrivateKey(byte[] encryptedData) throws Exception {  
    	return decryptByPrivateKey(encryptedData, getDefaultPrivateKey());
    }
  
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)  
            throws Exception {  
    	publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicK = keyFactory.generatePublic(x509KeySpec);  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicK);  
        int inputLen = encryptedData.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_DECRYPT_BLOCK;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return decryptedData;  
    }  
    
    public static byte[] decryptByPublicKey(byte[] encryptedData) throws Exception {
    	return decryptByPublicKey(encryptedData, getDefaultPublicKey());
    }
  
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)  
            throws Exception {  
    	publicKey = readKey(publicKey);
        byte[] keyBytes = Base64.decode(publicKey);  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicK = keyFactory.generatePublic(x509KeySpec);  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicK);  
        int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {  
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_ENCRYPT_BLOCK;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();  
        return encryptedData;  
    }  
    
    public static byte[] encryptByPublicKey(byte[] data) throws Exception {  
    	return encryptByPublicKey(data, getDefaultPublicKey());
    }
  
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)  
            throws Exception {  
    	privateKey = readKey(privateKey);
        byte[] keyBytes = Base64.decode(privateKey);  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, privateK);  
        int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {  
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_ENCRYPT_BLOCK;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();  
        return encryptedData;  
    }  
    
    public static byte[] encryptByPrivateKey(byte[] data) throws Exception { 
    	return encryptByPrivateKey(data, getDefaultPrivateKey());
    }
  
    public static String getPrivateKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PRIVATE_KEY);  
        return Base64.encode(key.getEncoded());  
    }  
  
    public static String getPublicKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PUBLIC_KEY);  
        return Base64.encode(key.getEncoded());  
    }
    
    public static String readKey(String rsaKey) throws Exception {
    	if(StringUtils.isEmpty(rsaKey)){
    		return null;
    	}
    	String regex = "((\\-).*?((\r\n)|\n))|((\\-).*?\\-$)";
    	return rsaKey.replaceAll(regex, "").trim();
    }
    
    public static String readKeyFile(File file) throws Exception {
    	return readKeyFile(new FileInputStream(file));
    }
    
	public static String readKeyFile(InputStream in) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String readLine = null;
		StringBuilder sb = new StringBuilder();
		while ((readLine = br.readLine()) != null) {
			if (readLine.charAt(0) == '-') {
				continue;
			} else {
				sb.append(readLine);
				sb.append('\r');
			}
		}
		if(br != null){
			br.close();
		}
		return sb.toString();
	}

	public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            
        }
        return d;
    }
	
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    
	public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

	private static String DEFAULT_PRIVATE_KEY_FILE = "/rsa/pkcs8_rsa_private_key.pem";
	
	private static String DEFAULT_PUBLIC_KEY_FILE = "/rsa/rsa_public_key.pem";
	
	private static String defaultPrivateKey = null;
	
	private static String defaultPublicKey = null;
	
	public static String getDefaultPrivateKey() throws Exception {
		if(defaultPrivateKey == null){
			defaultPrivateKey = RSAUtils.readKeyFile(RSAUtils.class.getResourceAsStream(DEFAULT_PRIVATE_KEY_FILE));
		}
		return defaultPrivateKey;
	}
  
    public static String getDefaultPublicKey() throws Exception {
    	if(defaultPublicKey == null){
    		defaultPublicKey = RSAUtils.readKeyFile(RSAUtils.class.getResourceAsStream(DEFAULT_PUBLIC_KEY_FILE));
		}
		return defaultPublicKey;
    }
    
	public static void main(String[] args) throws Exception {
		test1024();
	}
	
	public static void test1024() throws Exception {
		
		String srcText = "&emotion=&endTime=2019-09-18&pageIndex=1&pageRows=1&sourceType=[1]&startTime=2019-09-18";
		
		String rsaPrivateKey = RSAUtils.readKeyFile(RSAUtils.class.getResourceAsStream("/rsa/pkcs8_rsa_private_key.pem"));
		String rsaPublicKey = RSAUtils.readKeyFile(RSAUtils.class.getResourceAsStream("/rsa/rsa_public_key.pem"));
		
		String sign = RSAUtils.sign(srcText.getBytes(), rsaPrivateKey);
		System.err.println("The private key signature:\r" + sign);
		boolean status = RSAUtils.verify(srcText.getBytes(), rsaPublicKey, sign);
		System.err.println("Public key verification results:\r" + status);
		
	}
}  