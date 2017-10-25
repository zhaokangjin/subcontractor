package com.accenture.subcontractor.job.domain;

import java.util.Date;

public class ProjectsAchievement {
    // 项目业绩ID >>>表字段 : PROJECT_ACHIEVEMENT_ID
    private String projectAchievementId;

    // 开始日期 >>>表字段 : START_DATE
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    private Date endDate;

    // 业绩描述 >>>表字段 : ACHIEVEMENT_DESCR
    private String achievementDescr;

    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;

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
}