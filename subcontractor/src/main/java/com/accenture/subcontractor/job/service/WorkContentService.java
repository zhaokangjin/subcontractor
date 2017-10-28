package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.WorkContent;

public interface WorkContentService {
	public abstract void deleteBatch(List<WorkContent> recordList) ;
	public abstract void insertBatch(List<WorkContent> recordList) ;
	public abstract void updateBatch(List<WorkContent> recordList) ;

}
