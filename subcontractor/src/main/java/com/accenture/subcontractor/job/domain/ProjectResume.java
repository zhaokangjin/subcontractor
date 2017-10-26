package com.accenture.subcontractor.job.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectResume {
    // 项目经历ID >>>表字段 : PROJECT_RESUME_ID
    private String projectResumeId;

    // 开始日期 >>>表字段 : START_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startDate;

    // 结束日期 >>>表字段 : END_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    // 项目名称 >>>表字段 : PROJECT_NAME
    private String projectName;

    // 用户ID >>>表字段 : USER_ID
    private String userId;
    
    // 项目业绩表
    private List<ProjectsAchievement> projectsAchievementList;
    
    // 项目描述表
    private List<ProjectsDesc> projectsDescList;

    // 项目职责表
    private List<ProjectsDuty> projectsDutyList;
    
    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
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

	public List<ProjectsAchievement> getProjectsAchievementList() {
		return projectsAchievementList;
	}

	public void setProjectsAchievementList(List<ProjectsAchievement> projectsAchievementList) {
		this.projectsAchievementList = projectsAchievementList;
	}

	public List<ProjectsDesc> getProjectsDescList() {
		return projectsDescList;
	}

	public void setProjectsDescList(List<ProjectsDesc> projectsDescList) {
		this.projectsDescList = projectsDescList;
	}

	public List<ProjectsDuty> getProjectsDutyList() {
		return projectsDutyList;
	}

	public void setProjectsDutyList(List<ProjectsDuty> projectsDutyList) {
		this.projectsDutyList = projectsDutyList;
	}
}