package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Industry;

public interface IndustryMapper {
	int deleteByPrimaryKey(String tradeId);

	int insert(Industry record);

	int insertSelective(Industry record);

	Industry selectByPrimaryKey(String tradeId);

	int updateByPrimaryKeySelective(Industry record);

	int updateByPrimaryKey(Industry record);

	void insertBatch(List<Industry> recordList);

	void deleteBatch(List<Industry> recordList);

	void updateBatch(List<Industry> recordList);
}