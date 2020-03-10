package com.yz.sophia.insight.core.config;

import com.yz.sophia.bsf.utils.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    /**
     * 全局唯一ID生成类
     * @return
     */
    @Bean
    public SnowflakeIdWorker getSnowflakeIdWorker(){
        return new SnowflakeIdWorker();
    }
}
