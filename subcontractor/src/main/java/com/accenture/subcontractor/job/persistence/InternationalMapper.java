package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.International;

public interface InternationalMapper {
	int deleteByPrimaryKey(String internationalId);

	int insert(International record);

	int insertSelective(International record);

	International selectByPrimaryKey(String internationalId);

	int updateByPrimaryKeySelective(International record);

	int updateByPrimaryKey(International record);

	void insertBatch(List<International> recordList);

	void deleteBatch(List<International> recordList);

	void updateBatch(List<International> recordList);
}