package com.yz.sophia.insight.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	private final static int BUFFERED_SIZE = 2048;

	public static String post(String strURL, String params) {
		logger.debug(strURL);
		logger.debug(params);
		String result = "";
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		OutputStreamWriter out = null;
		try {
			URL url = new URL(strURL);// create connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			//connection.setRequestProperty("Accept", "application/json"); // Sets the format of the received data
			connection.setRequestProperty("Content-Type", "application/json"); // Sets the format for sending data
			connection.setRequestProperty("Content-Length", "" + params.getBytes("UTF-8").length); // Sets the format for sending data
			connection.addRequestProperty("language", "en");
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(30000);
			connection.connect();
			out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			out.append(params);
			out.flush();
			
			// read response inputstream
			is = connection.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] data = new byte[BUFFERED_SIZE];
			int count = 0;
			while ((count = is.read(data, 0, BUFFERED_SIZE)) > 0) {
				baos.write(data, 0, count);
			}
			result = new String(baos.toByteArray(), "UTF-8");
			logger.debug(result);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if(out != null){
					out.close();
				}
				if(baos != null){
					baos.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return result;
	}
}
