package com.accenture.subcontractor.job.domain;

public class AccountKey {
    // 账号名称 >>>表字段 : ACCOUNT_NUMBER_NAME
    private String accountNumberName;

    // 账号类型 >>>表字段 : ACCOUNT_NUMBER_TYPE
    private String accountNumberType;

    public String getAccountNumberName() {
        return accountNumberName;
    }

    public void setAccountNumberName(String accountNumberName) {
        this.accountNumberName = accountNumberName;
    }

    public String getAccountNumberType() {
        return accountNumberType;
    }

    public void setAccountNumberType(String accountNumberType) {
        this.accountNumberType = accountNumberType;
    }
}