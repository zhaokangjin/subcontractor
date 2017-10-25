package com.accenture.subcontractor.job.domain;

public class AddressProvice {
    // 主键ID >>>表字段 : id
    private Integer id;

    // 省份id、省份编号 >>>表字段 : provice_id
    private Integer proviceId;

    // 省份名称 >>>表字段 : provice_name
    private String proviceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviceId() {
        return proviceId;
    }

    public void setProviceId(Integer proviceId) {
        this.proviceId = proviceId;
    }

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }
}