package com.accenture.subcontractor.job.domain;

public class Address {
    //  >>>表字段 : id
    private Integer id;

    //  >>>表字段 : province_id
    private Long provinceId;

    //  >>>表字段 : province_name
    private String provinceName;

    //  >>>表字段 : city_id
    private Long cityId;

    //  >>>表字段 : city_name
    private String cityName;

    //  >>>表字段 : county_id
    private Long countyId;

    //  >>>表字段 : county_name
    private String countyName;

    //  >>>表字段 : town_id
    private Long townId;

    //  >>>表字段 : town_name
    private String townName;

    //  >>>表字段 : village_id
    private Long villageId;

    //  >>>表字段 : village_name
    private String villageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}