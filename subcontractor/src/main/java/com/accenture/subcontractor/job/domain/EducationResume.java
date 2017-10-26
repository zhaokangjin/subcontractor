package com.accenture.subcontractor.job.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EducationResume {
    // 教育经历ID >>>表字段 : EDUCATION_RESUME_ID
    private String educationResumeId;

    // 学校编码 >>>表字段 : UNIVERSITIES_CODE
    private String universitiesCode;

    // 学历编码 >>>表字段 : EDUCATION_CODE
    private String educationCode;

    // 专业编码 >>>表字段 : PROFESSION_CODE
    private String professionCode;

    // 入学日期 >>>表字段 : ENROL_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date enrolDate;

    // 毕业日期 >>>表字段 : GRADUATION_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date graduationDate;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;
    
    //成绩表
    private List<AchievementDesc> achievementDescList;
    
    //证书表
    private List<Certificate> certificateList;

    public String getEducationResumeId() {
        return educationResumeId;
    }

    public void setEducationResumeId(String educationResumeId) {
        this.educationResumeId = educationResumeId;
    }

    public String getUniversitiesCode() {
        return universitiesCode;
    }

    public void setUniversitiesCode(String universitiesCode) {
        this.universitiesCode = universitiesCode;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(String professionCode) {
        this.professionCode = professionCode;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public List<AchievementDesc> getAchievementDescList() {
		return achievementDescList;
	}

	public void setAchievementDescList(List<AchievementDesc> achievementDescList) {
		this.achievementDescList = achievementDescList;
	}

	public List<Certificate> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(List<Certificate> certificateList) {
		this.certificateList = certificateList;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}