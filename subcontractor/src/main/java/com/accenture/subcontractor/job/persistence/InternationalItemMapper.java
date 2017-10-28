package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Industry;
import com.accenture.subcontractor.job.domain.InternationalItem;

public interface InternationalItemMapper {
	public abstract int deleteByPrimaryKey(String itemId);

	public abstract int insert(InternationalItem record);

	public abstract int insertSelective(InternationalItem record);

	public abstract InternationalItem selectByPrimaryKey(String itemId);

	public abstract int updateByPrimaryKeySelective(InternationalItem record);

	public abstract int updateByPrimaryKey(InternationalItem record);
    
	public abstract int insertBatch(List<InternationalItem> recordList);

	public abstract int updateBatch(List<InternationalItem> recordList);

	public abstract int deleteBatch(List<InternationalItem> recordList);
}