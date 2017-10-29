package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.InternationalItem;

public interface InternationalItemMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(InternationalItem record);

    int insertSelective(InternationalItem record);

    InternationalItem selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(InternationalItem record);

    int updateByPrimaryKey(InternationalItem record);
    
	void insertBatch(List<InternationalItem> recordList);

	void deleteBatch(List<InternationalItem> recordList);

	void updateBatch(List<InternationalItem> recordList);
}