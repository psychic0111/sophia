package com.yz.sophia.ai.controller;

import com.yz.sophia.ai.model.enums.OCRFunctionEnum;
import com.yz.sophia.ai.model.enums.OCRTemplateEnum;
import com.yz.sophia.ai.model.response.HciOCRResp;
import com.yz.sophia.ai.provider.LingYunOCRProvider;
import com.yz.sophia.ai.service.LinYunOCRService;
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
 * ai服务-灵云OCR识别
 */
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3601)
@RestController("/lingyun/ocr")
public class LingYunOCRController extends BaseController implements LingYunOCRProvider {


    @Autowired
    private LinYunOCRService linYunOCRService;

    @Override
    @PostMapping("/distinguish")
    @ApiOperation("上传图像文件返回识别结果")
    public CommonResponse<Object> distinguish(MultipartFile files,
                                              @ApiParam(name = "capKey", value = "ocr识别能力：" +
                                                      "1.TEXT : 云端识别，支持中文简繁体识别（包括英文等）。\n" +
                                                      "2.CERTIFICATION : 云端模板识别，支持身份证、增值税发票、行驶证、驾驶证的识别。\n" +
                                                      "3.VISITINGCARD : 云端名片识别。\n" +
                                                      "4.BANKCARD : 云端银行卡识别。\n",
                                                      required = true) @RequestParam(name = "capKey", required = true) OCRFunctionEnum capKey,
                                              @ApiParam(name = "templateType", value = "选择CERTIFICATION时需选择模板信息：" +
                                                      "1.IDCARD_PERSON_SIDE : 身份证个人信息面\n" +
                                                      "2.IDCARD_GOV_SIDE : 身份证机关面\n" +
                                                      "3.PCN : 中国护照\n" +
                                                      "4.PID : 旅行证件\n" +
                                                      "5.BL : 营业执照\n" +
                                                      "6.DLC : 驾驶证\n" +
                                                      "7.VLC : 行驶证\n",
                                                      defaultValue = "IDCARD_PERSON_SIDE", required = false) @RequestParam(name = "templateType", required = false) OCRTemplateEnum templateType,
                                              @ApiParam(name = "needScore", value = "是否返回分数", defaultValue = "true", required = false) @RequestParam(name = "needScore", required = false) boolean needScore) {
        CommonResponse<Object> respCommonResponse = new CommonResponse<Object>();
        respCommonResponse = super.visit(() -> {
            HciOCRResp resp = null;
            try {
                String ns = needScore ? "yes" : "no";
                byte[] byteResult = linYunOCRService.distinguishByHttp(capKey, templateType, ns, null, files.getInputStream());
                String result = new String(byteResult, "utf-8");
                log.info("灵云接口返回：{}", result);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                resp.setCode(-1);
                resp.setMessage("图像数据IO异常");
            }
            return null;
        });
        return respCommonResponse;
    }
}
