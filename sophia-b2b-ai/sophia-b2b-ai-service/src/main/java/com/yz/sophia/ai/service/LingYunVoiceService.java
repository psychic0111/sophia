package com.yz.sophia.ai.service;

import com.alibaba.fastjson.JSONObject;
import com.yz.sophia.ai.utils.LYHttpAsrTool;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhaojing.jiang
 * @date 2020-03-14
 */
@Service
public class LingYunVoiceService {


    public Object LYHttpSend(MultipartFile files) {
        String result=null;
        LYHttpAsrTool httpTool = new LYHttpAsrTool();
        try {
            byte[] voiceData = files.getBytes();

            byte[] subVoiceData = new byte[voiceData.length];
            System.arraycopy(voiceData, 0, subVoiceData, 0, voiceData.length);
            byte[] byteResult = new byte[0];

            byteResult = httpTool.sendPost(subVoiceData);

            result = new String(byteResult, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isSuccess = result.contains("Success");
        if (isSuccess) {
            System.out.println(result);
        }
        JSONObject resultJson = JSONObject.parseObject(result);
        return resultJson;
    }
}
