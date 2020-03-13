package com.yz.sophia.insight.model.response;

import com.yz.sophia.insight.model.po.ApplyApplication;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@ApiModel(description = "审核回显查询接口对象")
public class ApplyApplicationRelResp extends ApplyApplication {

    @ApiModelProperty("应用申请接口选择关联表数据")
    private List<Map<String,Object>> ApplyApplicationRelList;
}
