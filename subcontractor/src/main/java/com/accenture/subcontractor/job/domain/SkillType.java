package com.accenture.subcontractor.job.domain;

public class SkillType {
    // 技能ID >>>表字段 : SKILL_ID
    private String skillId;

    // 技能名称 >>>表字段 : SKILL_NAME
    private String skillName;

    // 颜色 >>>表字段 : COLOR
    private String color;

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}