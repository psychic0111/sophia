package com.yz.sophia.bsf.core.config.base;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chejiangyi
 * @version: 2019-05-27 11:19
 **/
@Configuration
@Getter
public class BsfConfiguration {
    /**
     * 枚举:dev,test,prd
     */
    @Value("${bsf.env:dev}")
    private Environment env;
}
