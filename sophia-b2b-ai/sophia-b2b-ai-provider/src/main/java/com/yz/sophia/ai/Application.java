package com.yz.sophia.ai; /**
 * Application class
 *
 * @author huyalin
 * @date 2019/2/13
 */


//import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
//import com.alibaba.dubbo.spring.boot.context.event.DubboBannerApplicationListener;
import lombok.val;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableScheduling
/**
 * 为了dubbo 客户端兼容,注意要引用core里面dubbo相关的包
 */
//@EnableDubboConfiguration
@MapperScan(basePackages = "com.yz.sophia.ai.dao")
@ComponentScan(basePackages = "com.yz.sophia.ai")
public class Application {
    public static void main(String[] args) {
        /**
         * dubbo 客户端使用兼容,注意要引用core里面dubbo相关的包
         */
       // DubboBannerApplicationListener.setBANNER_MODE(Banner.Mode.OFF);
        val context = SpringApplication.run(Application.class, args);
        String a = context.getEnvironment().getProperty("test");
        int b=0;
    }
}
