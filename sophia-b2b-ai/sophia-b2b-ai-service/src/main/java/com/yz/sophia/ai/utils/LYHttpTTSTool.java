package com.yz.sophia.ai.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * @author wangyidong
 */

public class LYHttpTTSTool {
    private final static String APPKEY = "d95d5492";
    private final static String DEVELOPERKEY = "185c7df500fffaafec80c97890d49afd";
    private final static String CAPKEY = "tts.cloud.uyghur";
    private final static String CLOUDURL = "http://api.hcicloud.com:8880/tts/synthtext";
    private final static String SDKVERSION = "8.1";
    private final static String AUDIOFORMAT = "pcm16k16bit";
    private final static String TASKCONFIG = String.format("capkey=%s,audioformat=%s,", CAPKEY, AUDIOFORMAT);
    private final static String UDID = "101:1234567890";
    private final static String sPATH = System.getProperty("user.dir");//工程根目录
//    private static byte[] responseBody;//TTS响应结果

    //获取当前的时间并格式化
    protected static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(currentTime);
    }

    //发送HTTP POST请求
    public byte[] sendPost(String text, String capKey) {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod(CLOUDURL);
            postMethod.setRequestHeader("x-app-key", APPKEY);
            postMethod.setRequestHeader("x-sdk-version", SDKVERSION);
            postMethod.setRequestHeader("x-request-date", getNowDate());
            String taskConfig = String.format("capkey=%s,audioformat=%s,", capKey, AUDIOFORMAT);
            postMethod.setRequestHeader("x-task-config", taskConfig);
            postMethod.setRequestHeader("x-session-key", getXsessionkey(getNowDate(), DEVELOPERKEY));
            postMethod.setRequestHeader("x-udid", UDID);
            postMethod.setRequestEntity(new StringRequestEntity(text, null, "UTF-8"));
            httpClient.executeMethod(postMethod);
            byte[] responseBody = postMethod.getResponseBody();
            return responseBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成灵云平台需求的SessionKey密钥
    protected static String getXsessionkey(String currentTime, String developerkey) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageByte = (currentTime + developerkey).getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);
            return byteToHex(md5Byte);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return developerkey;

    }

    //Byte2Hex
    protected static String byteToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int count = 0; count < bytes.length; count++) {
            num = bytes[count];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }

    protected static void writePCM(byte[] responseBody) {
        try {
            //获取数据长度：dataLen
            if (responseBody == null) {
                return;
            }
            //获取二进制数据
            String postResult = new String(responseBody, "UTF-8");
            String[] split = postResult.split("</ResponseInfo>");
            String xmlStr = split[0].concat("</ResponseInfo>");
            System.out.println(xmlStr);
            byte[] voiceBytes = Arrays.copyOfRange(responseBody, xmlStr.length(), responseBody.length);
            System.out.println("实际音频数据长度:" + voiceBytes.length);

            //创建合成音频路径
            String filePath = sPATH + "\\testData";
            File fileDir = new File(filePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File file = new File(fileDir + "\\" + "synth.pcm");

            //写入合成音频结果
            System.out.println("合成音频路径：" + file.getPath());
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(voiceBytes);
            fos.flush();
            fos.close();
            System.out.println("写入文件成功");
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		sendPost(CLOUDURL);
//		writePCM(responseBody);
//	}
}
