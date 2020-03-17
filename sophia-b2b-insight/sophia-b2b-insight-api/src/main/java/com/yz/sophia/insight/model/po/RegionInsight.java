package com.yz.sophia.insight.model.po;

public class RegionInsight {
    private Long id;

    private String province;

    private String city;

    private String scenicSpot;

    private Integer regionId;

    public RegionInsight(Long id, String province, String city, String scenicSpot, Integer regionId) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.scenicSpot = scenicSpot;
        this.regionId = regionId;
    }

    public RegionInsight() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getScenicSpot() {
        return scenicSpot;
    }

    public void setScenicSpot(String scenicSpot) {
        this.scenicSpot = scenicSpot == null ? null : scenicSpot.trim();
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}