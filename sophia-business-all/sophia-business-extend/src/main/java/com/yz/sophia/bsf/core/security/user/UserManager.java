package com.yz.sophia.bsf.core.security.user;


import com.yz.sophia.bsf.core.base.model.GeneralDO;
import com.yz.sophia.bsf.core.security.model.Location;
import com.yz.sophia.bsf.core.security.model.PurchaseGroup;
import com.yz.sophia.bsf.core.security.model.PurchaseOrg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yanglikai on 2019/4/16.
 */
public final class UserManager {

  private SecurityUser user;

  private UserManager() {
    this.user = UserContext.getUser();
  }

  public static UserManager init() {
    return new UserManager();
  }

  public void fill(GeneralDO target) {
    target.setCreateBy(getUserName());
    target.setUpdateBy(getUserName());
  }

  public SecurityUser getUser() {
    return user;
  }

  public Long getUserId() {
    return user.fetchUserId();
  }

  public String getUserName() {
    return user.fetchUserName();
  }

  public <T> T getProperties(String key) {
    return user.fetchProperties(key);
  }

  public String getPurchaseOrgCode(String location) {
    if (user.fetchOrganizations() == null) {
      return "";
    }

    for (PurchaseOrg el : user.fetchOrganizations()) {
      if (el.getLocationCode().equals(location)) {
        return el.getPurchaseOrgCode();
      }
    }

    return "";
  }

  public List<PurchaseOrg> getPurchaseOrg() {
    return user.fetchOrganizations();
  }

  public List<PurchaseGroup> getPurchaseGroup() {
    return user.fetchPurchaseGroups();
  }

  public boolean checkProductPermission(String purchaseGroupCode) {
    Set<String> userPurchaseGroupCodeList = getPurchaseGroupCodeList();

    return userPurchaseGroupCodeList.contains(purchaseGroupCode);
  }


  public boolean checkPurchaseOrgPermission(String purchaseOrgCode) {
    Set<String> purchaseOrgList = getPurchaseOrgSet();
    return purchaseOrgList.contains(purchaseOrgCode);
  }

  public boolean checkLocationPermission(String location) {
    Set<String> userLocationCodeList = getLocationCodeList();

    return userLocationCodeList.contains(location);
  }

  private Set<String> getPurchaseGroupCodeList() {
    if (user.fetchPurchaseGroups() == null) {
      return new HashSet<>();
    }

    return
        user.fetchPurchaseGroups().stream()
            .map(PurchaseGroup::getPurchaseGroupCode)
            .distinct()
            .collect(Collectors.toSet());
  }

  private Set<String> getPurchaseOrgSet() {
    if (user.fetchOrganizations() == null) {
      return new HashSet<>();
    }
    return
        user.fetchOrganizations().stream()
            .map(PurchaseOrg::getPurchaseOrgCode)
            .distinct()
            .collect(Collectors.toSet());

  }

  public List<String> getPurchaseGroupList() {
    if (user.fetchPurchaseGroups() == null) {
      return new ArrayList<>();
    }
    return user.fetchPurchaseGroups()
        .stream()
        .map(PurchaseGroup::getPurchaseGroupCode)
        .distinct()
        .collect(Collectors.toList());
  }

  public List<String> getPurchaseOrgList() {
    if (user.fetchOrganizations() == null) {
      return new ArrayList<>();
    }
    return
        user.fetchOrganizations().stream()
            .map(PurchaseOrg::getPurchaseOrgCode)
            .distinct()
            .collect(Collectors.toList());

  }

  private Set<String> getLocationCodeList() {
    if (user.fetchLocations() == null) {
      return new HashSet<>();
    }

    return
        user.fetchLocations().stream()
            .map(Location::getLocationCode)
            .collect(Collectors.toSet());
  }
}
