package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.DictionariesItem;

public interface DictionariesItemMapper {
	public abstract int deleteByPrimaryKey(String itemCode);

	public abstract int insert(DictionariesItem record);

	public abstract int insertSelective(DictionariesItem record);

	public abstract DictionariesItem selectByPrimaryKey(String itemCode);

	public abstract int updateByPrimaryKeySelective(DictionariesItem record);

	public abstract int updateByPrimaryKey(DictionariesItem record);

	public abstract int insertBatch(List<DictionariesItem> recordList);

	public abstract int updateBatch(List<DictionariesItem> recordList);

	public abstract int deleteBatch(List<DictionariesItem> recordList);
}