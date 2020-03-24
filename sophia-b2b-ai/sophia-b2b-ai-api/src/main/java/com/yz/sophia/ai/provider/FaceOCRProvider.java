package com.yz.sophia.ai.provider;

import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * FeignClient命名规则说明:
 * name 为提供服务的${spring.application.name}名称,不能写错,否则使用api的客户端在注册中心无法找到对应的服务。
 * 比如sophia-b2b-stargaze-provider 为sophia-b2b-stargaze项目provider模块提供的服务
 * path 为api的相对路径,格式:${server.servlet.context-path|/相对路径
 * 比如/api/customer
 */
@Api("ai服务旷视OCR接口")
@FeignClient(name = "sophia-b2b-ai-provider", path = "/api/face")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ocr")
public interface FaceOCRProvider {

    @PostMapping("/idcard")
    @ApiOperation("身份证识别功能")
    CommonResponse<Object> idcard(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files,
                                  @ApiParam(name = "legality",
                                           value = "是否返回身份证照片合法性检查结果, 值可以取：1.返回 0.不返回, 默认0，付费后才可用此参数",
                                           defaultValue = "0",
                                           readOnly = true,
                                           required = false) @RequestParam(name = "legality", required = false) int legality);

    @PostMapping("/driverlicense")
    @ApiOperation("驾驶证识别功能")
    CommonResponse<Object> driverlicense(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files,
                                         @ApiParam(name = "returnScore",
                                               value = "是否返回置信度, 值可以取：1.返回 0.不返回, 默认0，付费后才可用此参数",
                                               defaultValue = "0",
                                               readOnly = true,
                                               required = false) @RequestParam(name = "returnScore", required = false) int returnScore,
                                         @ApiParam(name = "mode",
                                                 value = "使用该API的快速识别模式还是完备识别模式, 值可以取：fast或complete, 默认0complete. 快速识别模式只可识别驾照正本(main sheet)正面；完备识别模式支持识别驾照正本和副本。",
                                                 defaultValue = "complete",
                                                 required = false) @RequestParam(name = "mode", required = false) String mode);

    @PostMapping("/vehiclelicense")
    @ApiOperation("行驶证识别功能")
    CommonResponse<Object> vehiclelicense(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files);

    @PostMapping("/bankcard")
    @ApiOperation("银行卡识别功能")
    CommonResponse<Object> bankcard(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files);
}
