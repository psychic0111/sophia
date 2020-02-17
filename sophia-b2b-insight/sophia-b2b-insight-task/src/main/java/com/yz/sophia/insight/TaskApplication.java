package com.yz.sophia.insight;

//import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
//import com.alibaba.dubbo.spring.boot.context.event.DubboBannerApplicationListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/**
 * 兼容旧dubbo使用
 */
//@EnableDubboConfiguration
@MapperScan(basePackages = "com.yz.sophia.insight.dao")
@ComponentScan(basePackages = "com.yz.sophia.insight")
@EnableEurekaClient
@EnableFeignClients
public class TaskApplication {
	public static void main(String[] args) {
		/**
		 * 兼容旧dubbo使用
		 */
		//DubboBannerApplicationListener.setBANNER_MODE(Banner.Mode.OFF);
		SpringApplication.run(TaskApplication.class, args);
	}
}
