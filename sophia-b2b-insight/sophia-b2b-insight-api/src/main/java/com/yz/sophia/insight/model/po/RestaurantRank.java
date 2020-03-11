package com.yz.sophia.insight.model.po;

public class RestaurantRank {
    private Long id;

    private String restaurantCategory;

    private String restaurantClassify;

    private String restaurantBrand;

    private Integer rank;

    private Integer redListIndex;

    private String companyProfile;

    private String website;

    private String telephone;

    private String companyName;

    private String address;

    private String businessScope;

    private String restaurantType;

    public RestaurantRank(Long id, String restaurantCategory, String restaurantClassify, String restaurantBrand, Integer rank, Integer redListIndex, String companyProfile, String website, String telephone, String companyName, String address, String businessScope, String restaurantType) {
        this.id = id;
        this.restaurantCategory = restaurantCategory;
        this.restaurantClassify = restaurantClassify;
        this.restaurantBrand = restaurantBrand;
        this.rank = rank;
        this.redListIndex = redListIndex;
        this.companyProfile = companyProfile;
        this.website = website;
        this.telephone = telephone;
        this.companyName = companyName;
        this.address = address;
        this.businessScope = businessScope;
        this.restaurantType = restaurantType;
    }

    public RestaurantRank() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory == null ? null : restaurantCategory.trim();
    }

    public String getRestaurantClassify() {
        return restaurantClassify;
    }

    public void setRestaurantClassify(String restaurantClassify) {
        this.restaurantClassify = restaurantClassify == null ? null : restaurantClassify.trim();
    }

    public String getRestaurantBrand() {
        return restaurantBrand;
    }

    public void setRestaurantBrand(String restaurantBrand) {
        this.restaurantBrand = restaurantBrand == null ? null : restaurantBrand.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRedListIndex() {
        return redListIndex;
    }

    public void setRedListIndex(Integer redListIndex) {
        this.redListIndex = redListIndex;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile == null ? null : companyProfile.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType == null ? null : restaurantType.trim();
    }
}