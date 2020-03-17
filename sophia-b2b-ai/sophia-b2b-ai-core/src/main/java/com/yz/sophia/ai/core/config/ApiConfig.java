package com.yz.sophia.ai.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api")
public class ApiConfig {

    private String appKey;

    private String devKey;

    private String serverAddress;

    private String capKey;
}
