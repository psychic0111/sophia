package com.yz.sophia.insight.model.response;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.ApplyApplication;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "申请接口回列表对象")
public class ApplyApplicationResp {

    @ApiModelProperty("申请接口返回分页数据")
    private Page<ApplyApplication> applicationPageData;
}
