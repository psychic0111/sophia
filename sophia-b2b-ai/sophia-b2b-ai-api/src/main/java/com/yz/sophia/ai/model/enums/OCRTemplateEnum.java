package com.yz.sophia.ai.model.enums;

public enum OCRTemplateEnum {
    IDCARD_PERSON_SIDE("idcard ", 0, 0),
    IDCARD_GOV_SIDE("idcard ", 0, 1),
    VAT("vat", 0, 0),
    PCN("pcn", 0, 0),
    PID("pid", 0, 0),
    BL("bl", 0, 0),
    DLC("dlcard", 0, 0),
    VLC("vlcard", 0, 0);

    private String property;
    private int templateIndex;
    private int templatePageIndex;

    OCRTemplateEnum(String property, int templateIndex, int templatePageIndex) {
        this.property = property;
        this.templateIndex = templateIndex;
        this.templatePageIndex = templatePageIndex;
    }

    OCRTemplateEnum(String property) {
        this.property = property;
        this.templateIndex = 0;
        this.templatePageIndex = 0;
    }

    public String getProperty() {
        return property;
    }

    public int getTemplateIndex() {
        return templateIndex;
    }

    public int getTemplatePageIndex() {
        return templatePageIndex;
    }
}
