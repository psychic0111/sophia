package com.yz.sophia.insight.model.response;

import com.yz.sophia.insight.model.qo.LzSearchQo;
import lombok.Data;

import java.util.List;

@Data
public class LzSearchBodyResp {
    private int pageRows;

    private int pageCount;

    private int pageIndex;

    private int totalRows;

    private List<LzSearchQo> list;
}
