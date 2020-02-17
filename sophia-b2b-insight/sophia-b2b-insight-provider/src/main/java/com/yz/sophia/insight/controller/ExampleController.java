package com.yz.sophia.insight.controller;

import com.yz.sophia.insight.service.MQExampleSerivice;
import com.yz.sophia.insight.service.MessageExampleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chejiangyi
 * @version: 2019-06-13 17:38
 **/
@Slf4j
@Api("示例服务:仅测试")
@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private MQExampleSerivice mqExampleSerivice;
    @Autowired
    private MessageExampleService messageExampleService;

    @GetMapping("/registerConsumer")
    public void registerConsumer() {
         mqExampleSerivice.registerConsumer();
    }

    @GetMapping("/sendMessage")
    public void sendMessage() {
         mqExampleSerivice.sendMessage();
    }

    @GetMapping("/sendSms")
    public void sendSms() {
        messageExampleService.sendSms(0,"1122");
    }
}
