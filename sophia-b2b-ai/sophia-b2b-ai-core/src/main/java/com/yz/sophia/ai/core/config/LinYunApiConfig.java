package com.yz.sophia.ai.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 灵云接口API配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "lyapi")
public class LinYunApiConfig {

    private String appKey;

    private String devKey;

    private String serverAddress;

    private String capKey;
}
