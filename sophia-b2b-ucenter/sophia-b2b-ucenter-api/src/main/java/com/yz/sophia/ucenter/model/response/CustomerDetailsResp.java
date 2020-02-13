package com.yz.sophia.ucenter.model.response;

import com.yz.sophia.ucenter.model.request.CustomerAddReq;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDetailsResp extends CustomerAddReq {

    @ApiModelProperty("客户地址省名称")
    private String regionProvinceName;

    @ApiModelProperty("客户类型")
    private String type;
}
