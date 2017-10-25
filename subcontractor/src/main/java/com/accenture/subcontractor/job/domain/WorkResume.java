package com.accenture.subcontractor.job.domain;

import java.util.Date;

public class WorkResume {
    // 履历ID >>>表字段 : RESUME_ID
    private String resumeId;

    // 职位头衔 >>>表字段 : TITLE_RANK
    private String titleRank;

    // 公司名称 >>>表字段 : COMPANY_NAME
    private String companyName;

    // 入职日期 >>>表字段 : ENTRY_DATE
    private Date entryDate;

    // 离职日期 >>>表字段 : QUIT_DATE
    private Date quitDate;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getTitleRank() {
        return titleRank;
    }

    public void setTitleRank(String titleRank) {
        this.titleRank = titleRank;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}