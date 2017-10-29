package com.accenture.subcontractor.job.domain;

public class AccountKey {
    // 账号类型 >>>表字段 : ACCOUNT_NUMBER_TYPE
    private String accountNumberType;

    // 账号ID >>>表字段 : ACCOUNT_NUMBER_ID
    private String accountNumberId;

    public String getAccountNumberType() {
        return accountNumberType;
    }

    public void setAccountNumberType(String accountNumberType) {
        this.accountNumberType = accountNumberType;
    }

    public String getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(String accountNumberId) {
        this.accountNumberId = accountNumberId;
    }
}