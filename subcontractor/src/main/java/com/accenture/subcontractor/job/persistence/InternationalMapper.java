package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.International;

public interface InternationalMapper {
	public abstract int deleteByPrimaryKey(String internationalId);

    public abstract int insert(International record);

    public abstract int insertSelective(International record);

    public abstract International selectByPrimaryKey(String internationalId);

    public abstract int updateByPrimaryKeySelective(International record);

    public abstract int updateByPrimaryKey(International record);
    
	public abstract int insertBatch(List<International> recordList);

	public abstract int updateBatch(List<International> recordList);

	public abstract int deleteBatch(List<International> recordList);
}