package com.yz.sophia.ai.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "旷视接口返回实体")
public class FaceApiResp {

    @ApiModelProperty(value = "系统请求ID")
    private String request_id;

    @ApiModelProperty(value = "被检测出的文字信息，由一个或多个data对象组成")
    private Object result;

    @ApiModelProperty(value = "被检测的图片在系统中的标识")
    private String image_id;

    @ApiModelProperty(value = "整个请求所花费的时间，单位为毫秒")
    private int time_used;

    @ApiModelProperty(value = "当请求失败时才会返回此字符串，具体返回内容见后续错误信息章节。否则此字段不存在")
    private String error_message;
}
