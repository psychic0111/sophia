package com.yz.sophia.ai.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 旷视Face++接口配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "faceapi")
public class FaceApiConfig {

    private String key;

    private String secret;

    private String serverAddress = "https://api-cn.faceplusplus.com";

}
