package com.yz.sophia.insight.model.enums;

public enum LawResultEnum {
    SUCCESS("000", "成功"),
    FAIL("001", "失败"),
    EXCEPTION("001", "异常");

    private String code;
    private String name;

    LawResultEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
