package com.yz.sophia.demo.model.enums;

public enum CustomerStatusEnum {
    PENDING("01", "待审批"),
    ONGOING("02", "审批中"),
    REJECT("03", "审批拒绝"),
    PASS("04", "审批通过");

    private String code;
    private String name;

    CustomerStatusEnum(String code, String name) {
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
