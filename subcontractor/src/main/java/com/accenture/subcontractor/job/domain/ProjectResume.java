package com.accenture.subcontractor.job.domain;

import java.util.Date;

public class ProjectResume {
    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 开始日期 >>>表字段 : START_DATE
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    private Date endDate;

    // 项目名称 >>>表字段 : PROJECT_NAME
    private String projectName;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;

    public String getProjectResumeId() {
        return projectResumeId;
    }

    public void setProjectResumeId(String projectResumeId) {
        this.projectResumeId = projectResumeId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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