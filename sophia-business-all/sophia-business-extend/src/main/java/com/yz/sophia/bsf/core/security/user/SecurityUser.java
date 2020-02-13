package com.yz.sophia.bsf.core.security.user;

import com.yz.sophia.bsf.core.security.model.Location;
import com.yz.sophia.bsf.core.security.model.PurchaseGroup;
import com.yz.sophia.bsf.core.security.model.PurchaseOrg;

import java.util.List;

/**
 * Created by yanglikai on 2019/4/16.
 */
public interface SecurityUser {

  String fetchToken();

  Long fetchUserId();

  String fetchUserName();

  String fetchUserAccount();

  List<PurchaseOrg> fetchOrganizations();

  List<PurchaseGroup> fetchPurchaseGroups();

  List<Location> fetchLocations();

  default <T> T fetchProperties(String key) {
    return null;
  }
}
