package com.yz.sophia.insight.model.response;

import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.LegalInstrument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "法律文书返回列表对象")
public class LegalInstrumentResp {

    @ApiModelProperty("法律文书返回分页数据")
    private Page<LegalInstrument> legalPageData;
}
