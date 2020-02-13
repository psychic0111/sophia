package com.yz.sophia.bsf.core.security.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2019/7/23.
 */
@Data
@Builder
public class PurchaseOrg {

  private String purchaseOrgCode;

  private String purchaseOrgName;

  private String regionCode;

  private String regionName;

  private Long shopGroupId;

  private String shopGroupCode;

  private String shopGroupName;

  private Long locationId;

  private String locationCode;

  private String locationFullName;

  private String locationShortName;

  private Long shopTypeId;

  private String shopType;

  private String shopTypeName;
}
