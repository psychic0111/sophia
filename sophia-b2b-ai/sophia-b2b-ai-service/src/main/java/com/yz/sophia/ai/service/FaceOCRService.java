package com.yz.sophia.ai.service;

import com.yz.sophia.ai.core.config.AIConfig;
import com.yz.sophia.ai.model.enums.FaceOCRURLEnum;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceOCRService {

    @Autowired
    private AIConfig aiConfig;

    public String distinguish(FaceOCRURLEnum ocrurlEnum, String userId, byte[] data) throws Exception {
        String serverAddress = aiConfig.getFaceapi().getServerAddress();
        String url = serverAddress + ocrurlEnum.getUrl();
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setContentCharset("UTF-8");
        PostMethod postMethod = new PostMethod(url);

        postMethod.setParameter("api_key", aiConfig.getFaceapi().getKey());
        postMethod.setParameter("api_secret", aiConfig.getFaceapi().getSecret());
        RequestEntity entity = new ByteArrayRequestEntity(data);
        postMethod.setRequestEntity(entity);
        httpClient.executeMethod(postMethod);
        String response = postMethod.getResponseBodyAsString();
        return response;
    }
}
