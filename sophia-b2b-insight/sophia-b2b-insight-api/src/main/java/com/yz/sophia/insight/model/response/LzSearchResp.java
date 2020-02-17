package com.yz.sophia.insight.model.response;

import lombok.Data;

@Data
public class LzSearchResp {
    private LzSearchHeaderResp head;

    private LzSearchBodyResp body;
}
