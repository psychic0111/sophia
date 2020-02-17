package com.yz.sophia.insight.model.response;

import lombok.Data;

@Data
public class LzSearchHeaderResp {
    private int code;

    private String id;

    private long startTime;

    private long endTime;

    private String message;

    private String version;

    private String sign;
}
