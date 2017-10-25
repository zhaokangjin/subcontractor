package com.accenture.subcontractor.job.domain;

import java.util.Date;

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
    private Date enrolDate;

    // 毕业日期 >>>表字段 : GRADUATION_DATE
    private Date graduationDate;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 创建时间 >>>表字段 : CREATE_TIME
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}