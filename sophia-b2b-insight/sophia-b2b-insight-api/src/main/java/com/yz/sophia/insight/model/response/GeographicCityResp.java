package com.yz.sophia.insight.model.response;

import com.yz.sophia.insight.model.po.ApplyApplication;
import com.yz.sophia.insight.model.po.GeographicCity;
import com.yz.sophia.insight.model.po.GeographicCityRel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@ApiModel(description = "地理统计数据接口对象")
public class GeographicCityResp extends GeographicCity {

    @ApiModelProperty("地理统计数据关联表数据")
    private List<GeographicCityRel> geographicCityRelList;
}
