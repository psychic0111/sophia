package com.yz.sophia.ai.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 		比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 		比如/api/customer
 */
@Api("ai服务灵云语音相关接口")
@FeignClient(name = "sophia-b2b-ai-provider",path = "/api/lingyun/voice")
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/voice")
public interface LingYunVoiceProvider {

	@PostMapping("/asr")
	@ApiOperation("上传语音文件返回中文识别结果")
	CommonResponse<Object> getASR(MultipartFile files);

}
