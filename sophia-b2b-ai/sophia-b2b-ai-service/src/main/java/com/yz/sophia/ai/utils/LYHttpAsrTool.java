package com.yz.sophia.ai.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LYHttpAsrTool {
    //循环成功计数器
    static int count = 0;
    //直接修改下列参数 就可以  进行不同的 账户测试 和  要翻译的 内容测试
    private final String developerkey = "185c7df500fffaafec80c97890d49afd";//开发者密钥，通过开发者社区获取
    private final String appkey = "d95d5492";//开发者密钥，通过开发者社区获取
    private final String capkey = "asr.cloud.freetalk";
    private final String domain = "common";
    private final String property = "chinese_16k_common";
    private final String realtime = "yes";
    private final String vadhead = "10000";
    private final String vadtail = "500";
    //私有云需要传property，公有云暂不需要	
    private final String audioformat = "pcm16k16bit";
    private final String requestUrl = "http://api.hcicloud.com:8880/asr/Recognise";

    /**
     * 发送post请求
     *
     * @param subVoiceData
     */
    @SuppressWarnings("deprecation")
    public byte[] sendPost(byte[] subVoiceData) throws IOException {
        HttpClient httpClient = new HttpClient();// 客户端实例化
        PostMethod postMethod = new PostMethod(requestUrl);
        postMethod.setRequestHeader("x-app-key", appkey);
        postMethod.setRequestHeader("x-sdk-version", "5.0");
        postMethod.setRequestHeader("x-request-date", getNowDate());
        //识别参数
        postMethod.setRequestHeader("x-task-config", String.format("capkey=%s,audioformat=%s", capkey, audioformat));
        postMethod.setRequestHeader("x-session-key", getXsessionkey(getNowDate(), developerkey));
//        postMethod.setRequestHeader("x-udid", "101:1234567890");
        postMethod.setRequestHeader("x-result-format", "json");
        postMethod.setRequestBody(new ByteArrayInputStream(subVoiceData));
        httpClient.executeMethod(postMethod);
        byte[] reponseBody = postMethod.getResponseBody();
        return reponseBody;
    }

    /**
     * 获取指定Assert文件中的数据
     *
     * @return
     */
    public static byte[] getFileData() {
//		String testData = System.getProperty("user.dir") + "\\testdata"+ "\\tuling"+"\\3加4等于几.amr";
        String testData = System.getProperty("user.dir") + "/testdata" + "/in.pcm";
        File fileSrc = new File(testData);
        if (!fileSrc.exists()) {
            return null;
        }

        int size = (int) fileSrc.length();

        try {
            FileInputStream rd = new FileInputStream(fileSrc);
            byte[] data = new byte[size];
            rd.read(data);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return null;
        }
    }

    /**
     * 生成这个x-session-key的方法
     *
     * @param date
     * @param devkey
     * @return
     */
    private String getXsessionkey(String date, String devkey) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // 创建一个md5算法对象  
            byte[] messageByte = (date + devkey).getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);             // 获得MD5字节数组,16*8=128位   
            return bytesToHex(md5Byte);                          // 转换为16进制字符串   
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取当前日期的方法  格式必须是“2017-10-19 10:10:11”的形式
     *
     * @return
     */
    private String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }


    // 二进制转十六进制
    private String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
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
}