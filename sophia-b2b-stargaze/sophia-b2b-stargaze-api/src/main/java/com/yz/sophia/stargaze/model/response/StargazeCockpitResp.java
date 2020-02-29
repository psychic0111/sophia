package com.yz.sophia.stargaze.model.response;

import com.yz.sophia.stargaze.model.po.CockpitStaChartData;
import com.yz.sophia.stargaze.model.po.CockpitStatisticalCharts;
import com.yz.sophia.stargaze.model.request.CustomerAddReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ApiModel("观星台图表数据响应vo")
public class StargazeCockpitResp extends CockpitStatisticalCharts {

    @ApiModelProperty("驾驶舱数据集合")
    private List<CockpitStaChartData> CockpitDatatList;

}
