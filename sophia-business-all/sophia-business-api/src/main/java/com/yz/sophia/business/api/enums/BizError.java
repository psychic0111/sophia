package com.yz.sophia.business.api.enums;

/**
 * 常规业务错误枚举
 */
public enum BizError {

    SUCCESS(200000, "成功"),
    COMMON_ERROR(400000, "业务异常"),
    SYSTEM_ERROR(500000, "系统异常"),

    ;
    private int code;
    private String message;

    BizError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
