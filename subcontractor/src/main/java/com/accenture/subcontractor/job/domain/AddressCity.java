package com.accenture.subcontractor.job.domain;

public class AddressCity {
    //  >>>表字段 : id
    private Integer id;

    // 地级市id >>>表字段 : province_id
    private Integer provinceId;

    // 县级市id >>>表字段 : city_id
    private Long cityId;

    //  >>>表字段 : city_name
    private String cityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
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
}