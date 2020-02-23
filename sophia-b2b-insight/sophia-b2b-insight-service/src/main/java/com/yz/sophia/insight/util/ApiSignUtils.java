package com.yz.sophia.insight.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * APIKEY Verification tools
 *
 * <p/>
 * Date 2019年9月17日 上午12:28:47
 * <p/>
 * 
 * @author Lucas
 */
public class ApiSignUtils {

	private static Logger logger = LoggerFactory.getLogger(ApiSignUtils.class);

	/**
	 * verify signature
	 * 
	 * <p/>
	 * Date 2019年10月6日 上午1:54:11
	 * <p/>
	 * @author Lucas
	 * 
	 * @param apikey
	 * @param map
	 * @param rsaPublicKey
	 * @param sign
	 * @return
	 */
	public static boolean verify(String apikey, Map<String, Object> map, String rsaPublicKey, String sign) {
		List<String> mapKeys = new ArrayList<>(map.keySet());
		Collections.sort(mapKeys);

		StringBuffer params = new StringBuffer();

		for (int i = 0, len = mapKeys.size(); i < len; i++) {
			String key = mapKeys.get(i);
			if(key.equals("list")){
				continue;
			}
			params.append("&");
			params.append(key);
			params.append("=");
			if(!map.containsKey(key) || map.get(key) == null || "".equals(map.get(key).toString())){
				params.append("");
			}else{
				params.append(map.get(key).toString());
			}
		}

		try {
			logger.debug("Prepare the string for inspection：" + params.toString());
			boolean result = RSAUtils.verify(params.toString().getBytes("UTF-8"), RSAUtils.readKey(rsaPublicKey), sign);
			return result;
		} catch (Exception e) {
			logger.error("Signature verification failed：" + apikey);
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	/**
	 * signature
	 * 
	 * <p/>
	 * Date 2019年10月6日 上午1:55:18
	 * <p/>
	 * @author Lucas
	 * 
	 * @param apikey
	 * @param map
	 * @param rsaPrivateKey
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static String sign(String apikey, Map<String, Object> map, String rsaPrivateKey) throws Exception {
		List<String> mapKeys = new ArrayList<>(map.keySet());
		Collections.sort(mapKeys);

		StringBuffer params = new StringBuffer();

		for (int i = 0, len = mapKeys.size(); i < len; i++) {
			String key = mapKeys.get(i);
			if(key.equals("list")){
				continue;
			}
			params.append("&");
			params.append(key);
			params.append("=");
			if(!map.containsKey(key) || map.get(key) == null || "".equals(map.get(key).toString())){
				params.append("");
			}else{
				params.append(map.get(key).toString());
			}
		}

		try {
			logger.debug("Prepare the string for inspection：" + params.toString());
			String result = RSAUtils.sign(params.toString().getBytes("UTF-8"), RSAUtils.readKey(rsaPrivateKey));
			return result;
		} catch (Exception e) {
			logger.error("Signature verification failed：" + apikey);
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		String content = "&pageCount=17&pageIndex=1&pageRows=50&totalRows=826";
		String sign = "AtAUlPqjUDy0k3QRgZUi6l0CL5rqhOetdyBp6V1OKmMjd3KWQxma+FbszXKCkYIsiP7CjbI9UeKkY5ykfByeH0z1Ut80GLProhEYNpTfZwfbA+7AlaUANMiDpPHsydkP0l5AWw2yJkLes9ObBrPb5YiVHO9b/oZedXUeEfLMcQQ=";
		String rsaPublicKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/api/rsa_public_key.pem"));
		System.out.println(RSAUtils.verify(content.getBytes(), RSAUtils.readKey(rsaPublicKey), sign));
	}

}

