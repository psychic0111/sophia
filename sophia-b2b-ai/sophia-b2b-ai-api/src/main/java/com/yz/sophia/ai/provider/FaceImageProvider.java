package com.yz.sophia.ai.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 比如/api/customer
 */
@Api("ai服务旷视图像接口")
@FeignClient(name = "sophia-b2b-ai-provider", path = "/api/face")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/image")
public interface FaceImageProvider {

    @PostMapping("/recognizetext")
    @ApiOperation("图片中文字识别功能")
    CommonResponse<Object> recognizeText(@ApiParam(name = "files", value = "上传图片", required = true) MultipartFile files);
}
