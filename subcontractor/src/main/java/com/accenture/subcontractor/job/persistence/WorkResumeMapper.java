package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.WorkResume;

public interface WorkResumeMapper {
    int deleteByPrimaryKey(String resumeId);

    int insert(WorkResume record);

    int insertSelective(WorkResume record);

    WorkResume selectByPrimaryKey(String resumeId);

    int updateByPrimaryKeySelective(WorkResume record);

    int updateByPrimaryKey(WorkResume record);
}