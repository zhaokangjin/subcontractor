package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Certificate {
    // 证书ID >>>表字段 : CERTIFICATE_ID
    private String certificateId;

    // 教育经历ID >>>表字段 : EDUCATION_RESUME_ID
    private String educationResumeId;

    // 证书名称 >>>表字段 : CERTIFICATE_NAME
    private String certificateName;

    // 证书编码 >>>表字段 : CERTIFICATE_CODE
    private String certificateCode;

    // 证书图片 >>>表字段 : CERTIFICATE_IMAGE
    private String certificateImage;

    // 颁发机构 >>>表字段 : AWARD_ORGAN
    private String awardOrgan;

    // 证书类型 >>>表字段 : CERTIFICATE_TYPE
    private String certificateType;

    // 颁发日期 >>>表字段 : AWARD_DATE
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date awardDate;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getEducationResumeId() {
        return educationResumeId;
    }

    public void setEducationResumeId(String educationResumeId) {
        this.educationResumeId = educationResumeId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getCertificateImage() {
        return certificateImage;
    }

    public void setCertificateImage(String certificateImage) {
        this.certificateImage = certificateImage;
    }

    public String getAwardOrgan() {
        return awardOrgan;
    }

    public void setAwardOrgan(String awardOrgan) {
        this.awardOrgan = awardOrgan;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public Date getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}