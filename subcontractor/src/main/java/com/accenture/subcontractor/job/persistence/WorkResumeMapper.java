package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.WorkResume;

public interface WorkResumeMapper {
	public abstract int deleteByPrimaryKey(String resumeId);

    public abstract int insert(WorkResume record);

    public abstract int insertSelective(WorkResume record);

    public abstract WorkResume selectByPrimaryKey(String resumeId);

    public abstract int updateByPrimaryKeySelective(WorkResume record);

    public abstract int updateByPrimaryKey(WorkResume record);
    
	public abstract int insertBatch(List<WorkResume> recordList);

	public abstract int updateBatch(List<WorkResume> recordList);

	public abstract int deleteBatch(List<WorkResume> recordList);
}