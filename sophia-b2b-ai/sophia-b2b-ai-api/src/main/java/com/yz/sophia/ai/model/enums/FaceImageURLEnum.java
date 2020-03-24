package com.yz.sophia.ai.model.enums;

public enum FaceImageURLEnum {

    TEXT("图片中文字识别", "/imagepp/v1/recognizetext");

    private String name;
    private String url;

    FaceImageURLEnum(String name, String url) {
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
