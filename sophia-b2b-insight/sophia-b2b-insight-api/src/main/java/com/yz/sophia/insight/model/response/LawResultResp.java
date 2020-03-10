package com.yz.sophia.insight.model.response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * 接口返回信息实体
 */

@Data
@ApiModel(description = "法律查询接口返回信息实体")
public class LawResultResp {

    @ApiModelProperty("业务响应码")//000代表成功；001代表失败，002代表异常
    private String rspCode;

    @ApiModelProperty("业务响应信息")
    private String rspMsg;

    /** 业务参数集合 */
    private Map<String, Object> map = null;

}
