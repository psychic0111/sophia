package com.yz.sophia.bsf.core.security.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2019/7/23.
 */
@Data
@Builder
public class Location {

  private Long locationId;

  private String locationCode;

  private String locationName;
}
