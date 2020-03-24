package com.yz.sophia.ai.controller;

import com.alibaba.fastjson.JSONObject;
import com.yz.sophia.ai.model.enums.FaceOCRURLEnum;
import com.yz.sophia.ai.provider.FaceOCRProvider;
import com.yz.sophia.ai.service.FaceOCRService;
import com.yz.sophia.business.api.entity.CommonResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * ai服务-旷视OCR识别
 */
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/face/ocr")
public class FaceOCRController extends BaseController implements FaceOCRProvider {


    @Autowired
    private FaceOCRService faceOCRService;

    @Override
    @PostMapping("/idcard")
    @ApiOperation("身份证识别")
    public CommonResponse<Object> idcard(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files,
                                         @ApiParam(name = "legality",
                                                 value = "是否返回身份证照片合法性检查结果, 值可以取：1.返回 0.不返回, 默认0，付费后才可用此参数",
                                                 defaultValue = "0",
                                                 readOnly = true,
                                                 required = false) @RequestParam(name = "legality", required = false) int legality) {

        CommonResponse<Object> respCommonResponse = new CommonResponse<Object>();
        respCommonResponse = super.visit(() -> {
            String response = faceOCRService.distinguish(FaceOCRURLEnum.IDCARD, null, files.getBytes());
            JSONObject object = JSONObject.parseObject(response);
            return object;
        });
        return respCommonResponse;
    }


    @Override
    @PostMapping("/driverlicense")
    @ApiOperation("驾驶证识别")
    public CommonResponse<Object> driverlicense(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files,
                                                @ApiParam(name = "returnScore",
                                                        value = "是否返回置信度, 值可以取：1.返回 0.不返回, 默认0，付费后才可用此参数",
                                                        defaultValue = "0",
                                                        readOnly = true,
                                                        required = false) @RequestParam(name = "returnScore", required = false) int returnScore,
                                                @ApiParam(name = "mode",
                                                        value = "使用该API的快速识别模式还是完备识别模式, 值可以取：fast或complete, 默认0complete. 快速识别模式只可识别驾照正本(main sheet)正面；完备识别模式支持识别驾照正本和副本。",
                                                        defaultValue = "complete",
                                                        required = false) @RequestParam(name = "mode", required = false) String mode) {
        CommonResponse<Object> respCommonResponse = new CommonResponse<Object>();
        respCommonResponse = super.visit(() -> {
            String response = faceOCRService.distinguish(FaceOCRURLEnum.DRIVERLICENSE, null, files.getBytes());
            JSONObject object = JSONObject.parseObject(response);
            return object;
        });
        return respCommonResponse;
    }

    @Override
    @PostMapping("/vehiclelicense")
    @ApiOperation("行驶证识别")
    public CommonResponse<Object> vehiclelicense(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files) {
        CommonResponse<Object> respCommonResponse = new CommonResponse<Object>();
        respCommonResponse = super.visit(() -> {
            String response = faceOCRService.distinguish(FaceOCRURLEnum.VEHICLELICENSE, null, files.getBytes());
            JSONObject object = JSONObject.parseObject(response);
            return object;
        });
        return respCommonResponse;
    }

    @Override
    @PostMapping("/bankcard")
    @ApiOperation("银行卡识别")
    public CommonResponse<Object> bankcard(@ApiParam(name="files", value="上传图片", required = true) MultipartFile files) {
        CommonResponse<Object> respCommonResponse = new CommonResponse<Object>();
        respCommonResponse = super.visit(() -> {
            String response = faceOCRService.distinguish(FaceOCRURLEnum.BANKCARD, null, files.getBytes());
            JSONObject object = JSONObject.parseObject(response);
            return object;
        });
        return respCommonResponse;
    }
}
