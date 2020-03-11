package com.yz.sophia.insight.core.config;

import com.yz.sophia.bsf.utils.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    /**
     * 装配BCryptPasswordEncoder用户密码的匹配
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder()	{
        return new BCryptPasswordEncoder();
    }
}
