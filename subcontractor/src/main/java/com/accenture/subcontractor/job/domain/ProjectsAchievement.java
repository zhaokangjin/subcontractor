package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectsAchievement {
    // 项目业绩ID >>>表字段 : PROJECT_ACHIEVEMENT_ID
    private String projectAchievementId;

    // 开始日期 >>>表字段 : START_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    // 业绩描述 >>>表字段 : ACHIEVEMENT_DESCR
    private String achievementDescr;

    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 最后修改人 >>>表字段 : LAST_UPDATE_PERSON
    private String lastUpdatePerson;

    // 最后修改时间 >>>表字段 : LAST_UPDATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    // 创建人 >>>表字段 : CREATOR
    private String creator;

    public String getProjectAchievementId() {
        return projectAchievementId;
    }

    public void setProjectAchievementId(String projectAchievementId) {
        this.projectAchievementId = projectAchievementId;
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

    public String getAchievementDescr() {
        return achievementDescr;
    }

    public void setAchievementDescr(String achievementDescr) {
        this.achievementDescr = achievementDescr;
    }

    public String getProjectResumeId() {
        return projectResumeId;
    }

    public void setProjectResumeId(String projectResumeId) {
        this.projectResumeId = projectResumeId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}