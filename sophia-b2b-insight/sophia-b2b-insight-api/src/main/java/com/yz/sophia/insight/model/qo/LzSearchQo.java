package com.yz.sophia.insight.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "检索结果体")
public class LzSearchQo {

    @ApiModelProperty(value = "地域")
    private String area;

    // 文章ID
    @ApiModelProperty(value = "文章ID")
    private String articleId;

    // 获取时间，格式：yyyy-MM-dd HH:mm:ss
    @ApiModelProperty(value = "获取时间")
    private String cjTime;

    // 文章内容
    @ApiModelProperty(value = "文章内容")
    private String content;

    // 文章作者
    @ApiModelProperty(value = "文章作者")
    private String creator;

    // 来源一级域名
    @ApiModelProperty(value = "来源一级域名")
    private String domain;

    // 情感值筛选： -1:负,1:正,2:中
    @ApiModelProperty(value = "情感值筛选： -1:负,1:正,2:中")
    private Integer emotion;

    // 素材类型： 0:图文,1:图集,2:视频
    @ApiModelProperty(value = "素材类型： 0:图文,1:图集,2:视频")
    private Integer infoType;

    // 发布时间， 格式：yyyy-MM-dd HH:mm:ss
    @ApiModelProperty(value = "发布时间")
    private String pubTime;

    // 境内外： 0:境内,1:境外
    @ApiModelProperty(value = "境内外： 0:境内,1:境外")
    private Integer region;

    // 网站名称
    @ApiModelProperty(value = "网站名称")
    private String siteName;

    // 信息来源
    @ApiModelProperty(value = "信息来源")
    private String source;

    // 文章标题
    @ApiModelProperty(value = "文章标题")
    private String title;

    // 原文链接
    @ApiModelProperty(value = "原文链接")
    private String ur;
}
