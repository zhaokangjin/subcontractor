package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.EducationResume;

public interface EducationResumeMapper {
    public abstract int deleteByPrimaryKey(String educationResumeId);

    public abstract int insert(EducationResume record);

    public abstract int insertSelective(EducationResume record);

    public abstract EducationResume selectByPrimaryKey(String educationResumeId);

    public abstract int updateByPrimaryKeySelective(EducationResume record);

    public abstract int updateByPrimaryKey(EducationResume record);
    
    public abstract int insertOrUpdateBatch(List<EducationResume> recordList);
    
	public abstract int insertBatch(List<EducationResume> recordList);

	public abstract int updateBatch(List<EducationResume> recordList);

	public abstract int deleteBatch(List<EducationResume> recordList);
    
}