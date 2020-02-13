package com.yz.sophia.ucenter.service;

import com.yz.sophia.bsf.message.sms.SmsProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: chejiangyi
 * @version: 2019-06-13 16:53
 * 消息发送demo
 * 短信发送demo 文档: http://10.252.192.10:8080/webdoc/view/Pubff808081685d412e016ac55bd8871e6e.html
 **/
@Slf4j
@Service
public class MessageExampleService {
    @Autowired(required = false)
    SmsProvider smsProvider;

    public void sendSms(int type, String content){
        if (type == 1) {
            smsProvider.sendVoiceCode("13486359972", content);
        } else {
            smsProvider.sendText("13486359972", content);
        }
    }
}
