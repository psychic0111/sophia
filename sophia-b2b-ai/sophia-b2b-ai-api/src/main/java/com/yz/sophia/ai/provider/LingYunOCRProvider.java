package com.yz.sophia.ai.provider;

import com.yz.sophia.ai.model.enums.OCRFunctionEnum;
import com.yz.sophia.ai.model.enums.OCRTemplateEnum;
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
@Api("ai服务灵云OCR接口")
@FeignClient(name = "sophia-b2b-ai-provider", path = "/api/lingyun/ocr")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ocr")
public interface LingYunOCRProvider {

    @PostMapping("/distinguish")
    @ApiOperation("上传图像文件返回识别结果")
    CommonResponse<Object> distinguish(MultipartFile files,
                                           @ApiParam(name = "capKey", value = "ocr识别能力：" +
                                                   "1. : 云端识别，支持中文简繁体识别（包括英文等）。\n" +
                                                   "2.ocr.cloud.template : 云端模板识别，支持身份证、增值税发票、行驶证、驾驶证的识别。\n" +
                                                   "3.ocr.cloud.bizcard : 云端名片识别。\n" +
                                                   "4.ocr.cloud.bankcard : 云端银行卡识别。\n",
                                                   defaultValue = "ocr.cloud", required = true) @RequestParam(name = "capKey", required = true) OCRFunctionEnum capKey,
                                           @ApiParam(name = "templateType", value = "选择CERTIFICATION时需选择模板信息：" +
                                                   "1.IDCARD_PERSON_SIDE : 身份证个人信息面\n" +
                                                   "2.IDCARD_GOV_SIDE : 身份证机关面\n" +
                                                   "3.PCN : 中国护照\n" +
                                                   "4.PID : 旅行证件\n" +
                                                   "5.BL : 营业执照\n" +
                                                   "6.DLC : 驾驶证\n" +
                                                   "7.VLC : 行驶证\n",
                                                   defaultValue = "IDCARD_PERSON_SIDE", required = false) @RequestParam(name = "templateType", required = false) OCRTemplateEnum templateType,
                                           @ApiParam(name = "needScore", value = "是否返回分数", defaultValue = "true", required = false) @RequestParam(name = "needScore", required = false) boolean needScore);
}
