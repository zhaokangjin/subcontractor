package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkContent {
    // 内容ID >>>表字段 : CONTENT_ID
    private String contentId;

    // 工作内容 >>>表字段 : WORK_CONTENT
    private String workContent;

    // 履历ID >>>表字段 : RESUME_ID
    private String resumeId;

    // 开始日期 >>>表字段 : START_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 部门名称 >>>表字段 : DEPARTMENT_NAME
    private String departmentName;

    // 职务 >>>表字段 : POST
    private String post;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}