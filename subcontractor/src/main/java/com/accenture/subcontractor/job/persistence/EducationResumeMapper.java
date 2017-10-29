package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.EducationResume;

public interface EducationResumeMapper {
	int deleteByPrimaryKey(String educationResumeId);

	int insert(EducationResume record);

	int insertSelective(EducationResume record);

	EducationResume selectByPrimaryKey(String educationResumeId);

	int updateByPrimaryKeySelective(EducationResume record);

	int updateByPrimaryKey(EducationResume record);

	void insertBatch(List<EducationResume> recordList);

	void deleteBatch(List<EducationResume> recordList);

	void updateBatch(List<EducationResume> recordList);
}