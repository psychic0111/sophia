package com.yz.sophia.stargaze.model.response;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.stargaze.model.po.SophiaOpenService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("sophia开放服务检索响应vo")
public class SophiaOpenDataResp {

    @ApiModelProperty("sophia开放服务数据集合")
    private Page<SophiaOpenService> sophiaOpenData;

}
