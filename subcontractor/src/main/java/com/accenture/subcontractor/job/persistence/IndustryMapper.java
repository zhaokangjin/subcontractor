package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Industry;

public interface IndustryMapper {
	public abstract int deleteByPrimaryKey(String tradeId);

	public abstract int insert(Industry record);

	public abstract int insertSelective(Industry record);

	public abstract Industry selectByPrimaryKey(String tradeId);

	public abstract int updateByPrimaryKeySelective(Industry record);

	public abstract int updateByPrimaryKey(Industry record);

	public abstract int insertBatch(List<Industry> recordList);

	public abstract int updateBatch(List<Industry> recordList);

	public abstract int deleteBatch(List<Industry> recordList);
}