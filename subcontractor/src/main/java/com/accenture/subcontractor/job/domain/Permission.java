package com.accenture.subcontractor.job.domain;

public class Permission {
    // 权限ID >>>表字段 : PERMISSION_ID
    private String permissionId;

    // 权限名称 >>>表字段 : PERMISSION_NAME
    private String permissionName;

    // 备注 >>>表字段 : REMARKS
    private String remarks;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}