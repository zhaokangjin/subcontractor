package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.EducationResume;

public interface EducationResumeMapper {
    int deleteByPrimaryKey(String educationResumeId);

    int insert(EducationResume record);

    int insertSelective(EducationResume record);

    EducationResume selectByPrimaryKey(String educationResumeId);

    int updateByPrimaryKeySelective(EducationResume record);

    int updateByPrimaryKey(EducationResume record);
}