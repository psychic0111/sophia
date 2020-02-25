package com.yz.sophia.insight.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api")
public class ApiConfig {

    private String version;

    private String key;

    private String searchArticlesByKeyword;

    private String searchArticlesByWebsite;

    private String searchArticlesBySource;
    /**律师案由分布*/
    private String lawyerCaseDistribute;
    /**律师案件类型分布*/
    private String lawyerCaseTypeDistribute;
    /**律师法院层级分布*/
    private String lawCourtLevelDistribute;
    /**律师案件时间分布*/
    private String lawCaseTimeDistribute;
    /**律师案件地区分布*/
    private String lawCaseAreaDistribute;
    /**律师诉讼阶段分布*/
    private String lawLitigationStepDistribute;
    /**律师客户类型分布*/
    private String lawCustomerTypeDistribute;
    /**律师判决胜诉率*/
    private String lawSentenceRate;
    /**律师判决标的额分布*/
    private String lawSentenceMoney;
    /**当事人案由分布*/
    private String clientCaseDistribute;
    /**当事人案件类型分布*/
    private String clientCaseTypeDistribute;
    /**当事人法院层级分布*/
    private String clientCourtLevelDistribute;
    /**当事人案件时间分布*/
    private String clientCaseTimeDistribute;
    /**当事人案件地区分布*/
    private String clientCaseAreaDistribute;
    /**当事人判决标的额分布*/
    private String clientSentenceMoney;
    /**当事人判决胜诉率*/
    private String clientSentenceRate;
}
