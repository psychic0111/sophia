package com.yz.sophia.insight.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "检索接口返回信息实体")
public class LzSearchResp {

    @ApiModelProperty("接口响应头")
    private LzSearchHeaderResp head;

    @ApiModelProperty("接口响应体")
    private LzSearchBodyResp body;
}
