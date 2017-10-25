package com.accenture.subcontractor.job.domain;

public class Dictionaries {
    // 字典编码 >>>表字段 : DICTIONARY_CODE
    private String dictionaryCode;

    // 描述 >>>表字段 : DESCR
    private String descr;

    // 国际化ID >>>表字段 : INTERNATIONAL_ID
    private String internationalId;

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getInternationalId() {
        return internationalId;
    }

    public void setInternationalId(String internationalId) {
        this.internationalId = internationalId;
    }
}