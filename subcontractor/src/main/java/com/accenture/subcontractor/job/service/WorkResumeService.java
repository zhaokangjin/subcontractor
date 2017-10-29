package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.WorkResume;

public interface WorkResumeService {

	public abstract void editBatch(List<WorkResume> recordList);

}
