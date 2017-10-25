package com.accenture.subcontractor.job.domain;

public class AddressTown {
    //  >>>表字段 : id
    private Integer id;

    // 县级市id >>>表字段 : county_id
    private Long countyId;

    // 镇id >>>表字段 : town_id
    private Long townId;

    //  >>>表字段 : town_name
    private String townName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
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
}