package com.accenture.subcontractor.job.domain;

public class Organization {
    // 组织ID >>>表字段 : ORGAN_ID
    private String organId;

    // 父ID >>>表字段 : PARENT_ID
    private String parentId;

    // 组织名称 >>>表字段 : ORGAN_NAME
    private String organName;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }
}