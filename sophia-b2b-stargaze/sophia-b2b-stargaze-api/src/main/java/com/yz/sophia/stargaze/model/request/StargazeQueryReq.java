package com.yz.sophia.stargaze.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yz.sophia.stargaze.model.vo.UploadFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
@ApiModel("观星台图表数据请求vo")
public class StargazeQueryReq {

    @ApiModelProperty("一级菜单（1=文化类，2=政治类，3=社会类，4=经济类）")
    private int parentTitle;

    @ApiModelProperty("二级菜单code")
    private String subTitleCode;

    @ApiModelProperty("图表位置(1=左上，2=左中，3=左下，4=中间，5=右上，6=右中，7=右下)")
    private int chartLocation;

    @ApiModelProperty("图表类型(1=柱状，2=饼状，3=地图)")
    private int chartType;

    @ApiModelProperty("所统计年份（待启用）")
    private String statisticsYear;

}
