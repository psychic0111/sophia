package com.yz.sophia.insight.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api")
public class ApiConfig {

    private String searchArticlesByKeyword;

    private String searchArticlesByWebsite;

    private String searchArticlesBySource;
}
