package com.yz.sophia.ai.model.enums;

public enum OCRFunctionEnum {
    CERTIFICATION("ocr.cloud.template", "证照"),  // 云端模板识别，支持身份证、增值税发票、行驶证、驾驶证的识别
    VISITINGCARD("ocr.cloud.bizcard", "名片"),
    BANKCARD("ocr.cloud.bankcard", "银行卡"),
    TEXT("ocr.cloud", "文本");

    private String code;
    private String name;

    OCRFunctionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    OCRFunctionEnum(String code) {
        this.code = code;
        this.name = "";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
