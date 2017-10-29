package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Dictionaries;

public interface DictionariesMapper {
	int deleteByPrimaryKey(String dictionaryCode);

	int insert(Dictionaries record);

	int insertSelective(Dictionaries record);

	Dictionaries selectByPrimaryKey(String dictionaryCode);

	int updateByPrimaryKeySelective(Dictionaries record);

	int updateByPrimaryKey(Dictionaries record);

	void insertBatch(List<Dictionaries> recordList);

	void deleteBatch(List<Dictionaries> recordList);

	void updateBatch(List<Dictionaries> recordList);
}