package com.accenture.subcontractor.job.domain;

public class InternationalItem {
    // 条目ID >>>表字段 : ITEM_ID
    private String itemId;

    // 名称 >>>表字段 : NAME
    private String name;

    // 国际化ID >>>表字段 : INTERNATIONAL_ID
    private String internationalId;

    // 国家编码 >>>表字段 : COUNTRY_CODE
    private String countryCode;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternationalId() {
        return internationalId;
    }

    public void setInternationalId(String internationalId) {
        this.internationalId = internationalId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}