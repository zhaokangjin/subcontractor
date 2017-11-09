package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account extends AccountKey {
    // 描述 >>>表字段 : DESCR
    private String descr;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 账号名称 >>>表字段 : ACCOUNT_NUMBER_NAME
    private String accountNumberName;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 照片 >>>表字段 : PHOTO
    private String photo;

    // 注册地 >>>表字段 : REGISTER_ADDRESS
    private String registerAddress;

    // 最后修改人 >>>表字段 : LAST_UPDATE_PERSON
    private String lastUpdatePerson;
    
    //绑定用户信息便于返回
    private User user;

    // 最后修改时间 >>>表字段 : LAST_UPDATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

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

    public String getAccountNumberName() {
        return accountNumberName;
    }

    public void setAccountNumberName(String accountNumberName) {
        this.accountNumberName = accountNumberName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    public void setLastUpdatePerson(String lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}