package com.yz.sophia.bsf.core.security.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2019/7/23.
 */
@Data
@Builder
public class PurchaseGroup {

  private Long purchaseGroupId;

  private String purchaseGroupCode;

  private String purchaseGroupName;
}
