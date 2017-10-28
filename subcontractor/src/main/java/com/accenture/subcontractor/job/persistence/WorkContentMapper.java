package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.WorkContent;

public interface WorkContentMapper {
	public abstract int deleteByPrimaryKey(String contentId);

    public abstract int insert(WorkContent record);

    public abstract int insertSelective(WorkContent record);

    public abstract WorkContent selectByPrimaryKey(String contentId);

    public abstract int updateByPrimaryKeySelective(WorkContent record);

    public abstract int updateByPrimaryKey(WorkContent record);
    
	public abstract int insertBatch(List<WorkContent> recordList);

	public abstract int updateBatch(List<WorkContent> recordList);

	public abstract int deleteBatch(List<WorkContent> recordList);
}