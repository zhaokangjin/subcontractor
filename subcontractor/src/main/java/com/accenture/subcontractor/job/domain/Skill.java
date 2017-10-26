package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Skill {
    // 专业技能ID >>>表字段 : PROFESSION_SKILL_ID
    private String professionSkillId;

    // 技能ID >>>表字段 : SKILL_ID
    private String skillId;

    // 所属ID >>>表字段 : BELONG_ID
    private String belongId;

    // 用户ID >>>表字段 : USER_ID
    private String userId;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 层级 >>>表字段 : LEVEL
    private String level;

    public String getProfessionSkillId() {
        return professionSkillId;
    }

    public void setProfessionSkillId(String professionSkillId) {
        this.professionSkillId = professionSkillId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}