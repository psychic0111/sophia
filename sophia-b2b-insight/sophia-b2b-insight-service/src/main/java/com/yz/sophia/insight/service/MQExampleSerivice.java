package com.yz.sophia.insight.service;

import com.yz.sophia.bsf.mq.rocketmq.RocketMQConsumerProvider;
import com.yz.sophia.bsf.mq.rocketmq.RocketMQProducerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: chejiangyi
 * @version: 2019-06-13 16:44
 * rocketmq 使用示范
 * rocketmq 使用文档:http://10.252.192.10:8080/webdoc/view/Pubff8080816aff1991016b500707553c73.html
 **/
@Slf4j
@Service
public class MQExampleSerivice {

    @Autowired(required = false)
    private RocketMQProducerProvider rocketMQProducerProvider;
    @Autowired(required = false)
    private RocketMQConsumerProvider rocketMQConsumerProvider;

    public void registerConsumer(){
        //订阅消息
        rocketMQConsumerProvider.subscribe("sophia-bsf-demo-test-consumer-01","sophia-bsf-demo-test",null,(msg)->{
            System.out.println(msg);
        },String.class);


    }

    public void sendMessage() {
        //发送消息
        rocketMQProducerProvider.sendMessage("sophia-bsf-demo-test",null,"测试"+ System.currentTimeMillis());
    }
}
