package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Dictionaries;

public interface DictionariesMapper {
	public abstract int deleteByPrimaryKey(String dictionaryCode);

	public abstract int insert(Dictionaries record);

	public abstract int insertSelective(Dictionaries record);

	public abstract Dictionaries selectByPrimaryKey(String dictionaryCode);

	public abstract int updateByPrimaryKeySelective(Dictionaries record);

	public abstract int updateByPrimaryKey(Dictionaries record);

	public abstract int insertBatch(List<Dictionaries> recordList);

	public abstract int updateBatch(List<Dictionaries> recordList);

	public abstract int deleteBatch(List<Dictionaries> recordList);
}