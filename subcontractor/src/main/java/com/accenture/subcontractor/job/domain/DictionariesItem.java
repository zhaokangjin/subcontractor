package com.accenture.subcontractor.job.domain;

public class DictionariesItem {
    // 条目编码 >>>表字段 : ITEM_CODE
    private String itemCode;

    // 描述 >>>表字段 : DESCR
    private String descr;

    // 国际化ID >>>表字段 : INTERNATIONAL_ID
    private String internationalId;

    // 字典编码 >>>表字段 : DICTIONARY_CODE
    private String dictionaryCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }
}