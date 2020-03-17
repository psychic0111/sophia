package com.yz.sophia.stargaze.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class POIProvinceDetailResp {

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("监测点数量")
    private int num;

    private Double lng;

    private Double lat;

    private Integer altitude;
}
