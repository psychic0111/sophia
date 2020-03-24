package com.yz.sophia.ai.model.enums;

public enum FaceOCRURLEnum {
    IDCARD("身份证", "/cardpp/v1/ocridcard"),
    DRIVERLICENSE("驾驶证", "/cardpp/v2/ocrdriverlicense"),
    VEHICLELICENSE("行驶证", "/cardpp/v1/ocrvehiclelicense"),
    BANKCARD("银行卡", "/cardpp/v1/ocrbankcard");

    private String name;
    private String url;

    FaceOCRURLEnum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
