package com.accenture.subcontractor.job.domain;

import java.util.Date;

public class Account extends AccountKey {
    // 描述 >>>表字段 : DESCR
    private String descr;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 账号ID >>>表字段 : ACCOUNT_NUMBER_ID
    private String accountNumberId;

    // 照片 >>>表字段 : PHOTO
    private String photo;

    // 注册地 >>>表字段 : REGISTER_ADDRESS
    private String registerAddress;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(String accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
}