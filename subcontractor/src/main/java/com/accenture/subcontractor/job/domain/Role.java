package com.accenture.subcontractor.job.domain;

public class Role {
    // 角色ID >>>表字段 : ROLE_ID
    private String roleId;

    // 角色名称 >>>表字段 : ROLE_NAME
    private String roleName;

    // 备注 >>>表字段 : REMARKS
    private String remarks;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}