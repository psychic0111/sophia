package com.yz.sophia.ai.model.response;

import com.yz.sophia.ai.model.request.CustomerAddReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class HciOCRResp extends CustomerAddReq {

    @ApiModelProperty("识别状态码")
    private int code;

    @ApiModelProperty("识别状态信息")
    private String message;

    private Object data;
}
