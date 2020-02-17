package com.yz.sophia.insight.model.qo;

import lombok.Data;

@Data
public class LzSearchQo {

    // 地域
    private String area;

    // 文章ID
    private String articleId;

    // 获取时间，格式：yyyy-MM-dd HH:mm:ss
    private String cjTime;

    // 文章内容
    private String content;

    // 文章作者
    private String creator;

    // 来源一级域名
    private String domain;

    // 情感值筛选： -1:负,1:正,2:中
    private Integer emotion;

    // 素材类型： 0:图文,1:图集,2:视频
    private Integer infoType;

    // 发布时间， 格式：yyyy-MM-dd HH:mm:ss
    private String pubTime;

    // 境内外： 0:境内,1:境外
    private Integer region;

    // 网站名称
    private String siteName;

    // 信息来源
    private String source;

    // 文章标题
    private String title;

    // 原文链接
    private String ur;
}
