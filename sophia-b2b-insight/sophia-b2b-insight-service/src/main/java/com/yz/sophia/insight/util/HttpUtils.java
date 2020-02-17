package com.yz.sophia.insight.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    private static final int BUFFERED_SIZE = 2048;

    public HttpUtils() {
    }

    public static String post(String strURL, String params) {
        logger.debug(strURL);
        logger.debug(params);
        String result = "";
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStreamWriter out = null;

        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", "" + params.getBytes("UTF-8").length);
            connection.addRequestProperty("language", "en");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.connect();
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(params);
            out.flush();
            is = connection.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] data = new byte[2048];
            boolean var9 = false;

            int count;
            while((count = is.read(data, 0, 2048)) > 0) {
                baos.write(data, 0, count);
            }

            result = new String(baos.toByteArray(), "UTF-8");
            logger.debug(result);
        } catch (IOException var18) {
            logger.error(var18.getMessage(), var18);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (out != null) {
                    out.close();
                }

                if (baos != null) {
                    baos.close();
                }
            } catch (Exception var17) {
                logger.error(var17.getMessage(), var17);
            }

        }

        return result;
    }
}
