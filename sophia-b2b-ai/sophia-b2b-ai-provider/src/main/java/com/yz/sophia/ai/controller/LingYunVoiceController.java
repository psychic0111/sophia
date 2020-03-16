package com.yz.sophia.ai.controller;

import com.yz.sophia.ai.provider.LingYunVoiceProvider;
import com.yz.sophia.ai.service.LingYunVoiceService;
import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * ai服务-灵云语音识别
 */
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/lingyun/voice")
public class LingYunVoiceController extends BaseController implements LingYunVoiceProvider {


    @Autowired
    private LingYunVoiceService lingYunVoiceService;


    @Override
    @PostMapping("/asr")
    @ApiOperation("上传语音文件返回中文识别结果")
    public CommonResponse<Object> getASR(MultipartFile files) {
        return super.visit(() -> {
            return lingYunVoiceService.LYHttpSend(files);
        });
    }
}
