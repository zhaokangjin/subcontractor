package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectsDuty {
    // 项目职责ID >>>表字段 : PROJECT_RESPONSIBILITY_ID
    private String projectResponsibilityId;

    // 开始日期 >>>表字段 : START_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    // 职责描述 >>>表字段 : RESPONSIBILITY_DESCR
    private String responsibilityDescr;

    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 职务 >>>表字段 : POST
    private String post;

    // 部门 >>>表字段 : DEPARTMENT
    private String department;

    public String getProjectResponsibilityId() {
        return projectResponsibilityId;
    }

    public void setProjectResponsibilityId(String projectResponsibilityId) {
        this.projectResponsibilityId = projectResponsibilityId;
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

    public String getResponsibilityDescr() {
        return responsibilityDescr;
    }

    public void setResponsibilityDescr(String responsibilityDescr) {
        this.responsibilityDescr = responsibilityDescr;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}