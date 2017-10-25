package com.accenture.subcontractor.job.domain;

public class International {
    // 国际化ID >>>表字段 : INTERNATIONAL_ID
    private String internationalId;

    // 描述 >>>表字段 : DESCR
    private String descr;

    // 键值 >>>表字段 : KEY_VALUE
    private String keyValue;

    public String getInternationalId() {
        return internationalId;
    }

    public void setInternationalId(String internationalId) {
        this.internationalId = internationalId;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}