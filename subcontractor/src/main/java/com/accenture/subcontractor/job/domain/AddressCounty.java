package com.accenture.subcontractor.job.domain;

public class AddressCounty {
    // 地级市主键ID >>>表字段 : id
    private Integer id;

    // 地级市id >>>表字段 : city_id
    private Long cityId;

    // 县级id >>>表字段 : county_id
    private Long countyId;

    //  >>>表字段 : county_name
    private String countyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
}