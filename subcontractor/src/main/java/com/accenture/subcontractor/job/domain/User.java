package com.accenture.subcontractor.job.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 姓名 >>>表字段 : NAME
    private String name;

    // 电话 >>>表字段 : PHONE
    private String phone;

    // 身份证 >>>表字段 : IDENTITY_CARD
    private String identityCard;

    // 行业ID >>>表字段 : TRADE_ID
    private String tradeId;

    // 籍贯 >>>表字段 : NATIVE_PLACE
    private String nativePlace;

    // 居住地 >>>表字段 : DOMICILE
    private String domicile;

    // 简介 >>>表字段 : INTRODUCTION
    private String introduction;

    // 邮箱 >>>表字段 : MAIL
    private String mail;

    // 密码 >>>表字段 : PASSWORD
    private String password;

    // 组织ID >>>表字段 : ORGAN_ID
    private String organId;

    // 性别—M（男）性;F（表示女性） >>>表字段 : SEX
    private String sex;

    // 角色ID >>>表字段 : ROLE_ID
    private String roleId;

    // 权限ID >>>表字段 : PERMISSION_ID
    private String permissionId;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 手机 >>>表字段 : MOBILE
    private String mobile;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 创建人 >>>表字段 : CREATOR
    private String creator;

    // 最后修改人 >>>表字段 : LAST_UPDATE_PERSON
    private String lastUpdatePerson;
    
    // 生日 >>>表字段 : BIRTHDAY
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;

    // 最后修改时间 >>>表字段 : LAST_UPDATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    private List<Account> accountList;
    
    private List<Skill> skillList;
    
    private List<WorkResume> workResumeList;
    
    private List<EducationResume> educationResumeList;
    
    private List<ProjectResume> projectResumeList;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public List<WorkResume> getWorkResumeList() {
		return workResumeList;
	}

	public void setWorkResumeList(List<WorkResume> workResumeList) {
		this.workResumeList = workResumeList;
	}

	public List<EducationResume> getEducationResumeList() {
		return educationResumeList;
	}

	public void setEducationResumeList(List<EducationResume> educationResumeList) {
		this.educationResumeList = educationResumeList;
	}

	public List<ProjectResume> getProjectResumeList() {
		return projectResumeList;
	}

	public void setProjectResumeList(List<ProjectResume> projectResumeList) {
		this.projectResumeList = projectResumeList;
	}

	public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

	public String getLastUpdatePerson() {
		return lastUpdatePerson;
	}

	public void setLastUpdatePerson(String lastUpdatePerson) {
		this.lastUpdatePerson = lastUpdatePerson;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}