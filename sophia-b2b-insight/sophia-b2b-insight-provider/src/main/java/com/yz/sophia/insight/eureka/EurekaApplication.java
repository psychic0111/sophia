package com.yz.sophia.insight.eureka;

import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.provider.CustomerProvider;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: chejiangyi
 * @version: 2019-06-28 14:18
 * Eureka client 调用其他客户端 api示例
 * 注意要配合properties 的配置使用
 **/
/****************调试时候去掉SpringBootApplication注释*************/
//@SpringBootApplication
/**
 * 【关键配置】需要使用的项目api 协议类,一般放provider包下面;多个项目则配置多个
 * 注意:spring.main.allow-bean-definition-overriding=true 必须要配置否则会报错
 */
@EnableFeignClients(basePackages = {"com.yz.sophia.insight.provider"})//"com.yz.sophia.ucenter.provider","com.yz.sophia.insight.provider"
public class EurekaApplication {
    /**
     * 获取注入对象方式一
     */
    @Autowired(required=false)
    CustomerProvider customerProvider;

    public static void main(String[] args) {
        val context = SpringApplication.run(com.yz.sophia.insight.Application.class, args);
        /**
         * 获取注入对象方式二
         */
        val provider = context.getBean(CustomerProvider.class);
        provider.addCustomer(new CustomerAddReq());
    }
}
