package com.yz.sophia.bsf.mq.base;

import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @author: chejiangyi
 * @version: 2019-06-12 14:49
 * 消费者提供者: 提供不同类型的消息队列的消费者
 **/
public class AbstractConsumerProvider extends AbstractProvider {
    public  <T> AbstractConsumer subscribe(String consumergroup, String topic, String[] filterTags, SubscribeRunable<T> runnable, Class<T> type) {return null;}
    public  <T> AbstractConsumer subscribe(String consumergroup,MessageModel mode,  String topic, String[] filterTags, SubscribeRunable<T> runnable, Class<T> type) {return null;}
}

