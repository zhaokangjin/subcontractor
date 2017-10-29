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
    
    private List<ProjectsAchievement>  projectsAchievementlist;
    
    private List<ProjectsDesc>  projectsDesclist;
    
    private List<ProjectsDuty>  projectsDutylist;

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

	public List<ProjectsAchievement> getProjectsAchievementlist() {
		return projectsAchievementlist;
	}

	public void setProjectsAchievementlist(List<ProjectsAchievement> projectsAchievementlist) {
		this.projectsAchievementlist = projectsAchievementlist;
	}

	public List<ProjectsDesc> getProjectsDesclist() {
		return projectsDesclist;
	}

	public void setProjectsDesclist(List<ProjectsDesc> projectsDesclist) {
		this.projectsDesclist = projectsDesclist;
	}

	public List<ProjectsDuty> getProjectsDutylist() {
		return projectsDutylist;
	}

	public void setProjectsDutylist(List<ProjectsDuty> projectsDutylist) {
		this.projectsDutylist = projectsDutylist;
	}
}