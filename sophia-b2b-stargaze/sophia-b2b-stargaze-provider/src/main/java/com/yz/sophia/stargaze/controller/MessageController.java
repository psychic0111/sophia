package com.yz.sophia.stargaze.controller;

import com.yz.sophia.bsf.message.sms.SmsProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huang Zhaoping
 * @date 2019/6/21
 */
@RestController
public class MessageController {
    //@Autowired
    private SmsProvider smsProvider;

    @GetMapping("/sendSms")
    public String sendMessage(String phone){
        smsProvider.sendText(phone, "CRM测试短信，收到请忽略！");
        return "done";
    }
}
