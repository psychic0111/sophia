package com.yz.sophia.insight.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LzSearchHeaderResp {
    @ApiModelProperty("响应码")
    private int code;
    @ApiModelProperty("接口ID")
    private String id;
    @ApiModelProperty("开始时间")
    private long startTime;

    private long endTime;

    private String message;

    private String version;

    private String sign;
}
