package com.accenture.subcontractor.job.domain;

import java.util.Date;

public class ProjectsDesc {
    // 项目描述ID >>>表字段 : PROJECT_DESCR_ID
    private String projectDescrId;

    // 开始日期 >>>表字段 : START_DATE
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    private Date endDate;

    // 项目描述 >>>表字段 : PROJECT_DESCR
    private String projectDescr;

    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;

    public String getProjectDescrId() {
        return projectDescrId;
    }

    public void setProjectDescrId(String projectDescrId) {
        this.projectDescrId = projectDescrId;
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

    public String getProjectDescr() {
        return projectDescr;
    }

    public void setProjectDescr(String projectDescr) {
        this.projectDescr = projectDescr;
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