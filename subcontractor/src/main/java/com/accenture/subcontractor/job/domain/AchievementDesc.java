package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AchievementDesc {
    // 成绩ID >>>表字段 : ACHIEVEMENT_ID
    private String achievementId;

    // 成绩描述 >>>表字段 : ACHIEVEMENT_DESCR
    private String achievementDescr;

    // 教育经历ID >>>表字段 : EDUCATION_RESUME_ID
    private String educationResumeId;

    // 开始日期 >>>表字段 : START_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 成绩名称 >>>表字段 : ACHIEVEMENT_NAME
    private String achievementName;

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementDescr() {
        return achievementDescr;
    }

    public void setAchievementDescr(String achievementDescr) {
        this.achievementDescr = achievementDescr;
    }

    public String getEducationResumeId() {
        return educationResumeId;
    }

    public void setEducationResumeId(String educationResumeId) {
        this.educationResumeId = educationResumeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }
}