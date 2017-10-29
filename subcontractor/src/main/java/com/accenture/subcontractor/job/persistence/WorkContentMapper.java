package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.WorkContent;

public interface WorkContentMapper {
	int deleteByPrimaryKey(String contentId);

	int insert(WorkContent record);

	int insertSelective(WorkContent record);

	WorkContent selectByPrimaryKey(String contentId);

	int updateByPrimaryKeySelective(WorkContent record);

	int updateByPrimaryKey(WorkContent record);

	void insertBatch(List<WorkContent> recordList);

	void deleteBatch(List<WorkContent> recordList);

	void updateBatch(List<WorkContent> recordList);
}