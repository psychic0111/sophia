package com.yz.sophia.insight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class InsightApiApplication {

    public static void main(String args[]){
        SpringApplication.run(InsightApiApplication.class, args);
    }
}
