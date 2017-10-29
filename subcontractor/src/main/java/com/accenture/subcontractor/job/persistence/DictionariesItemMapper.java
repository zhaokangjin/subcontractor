package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.DictionariesItem;

public interface DictionariesItemMapper {
	int deleteByPrimaryKey(String itemCode);

	int insert(DictionariesItem record);

	int insertSelective(DictionariesItem record);

	DictionariesItem selectByPrimaryKey(String itemCode);

	int updateByPrimaryKeySelective(DictionariesItem record);

	int updateByPrimaryKey(DictionariesItem record);

	void insertBatch(List<DictionariesItem> recordList);

	void deleteBatch(List<DictionariesItem> recordList);

	void updateBatch(List<DictionariesItem> recordList);
}