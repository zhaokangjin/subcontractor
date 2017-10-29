package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.EducationResume;

public interface EducationResumeService {
	public abstract void editBatch(List<EducationResume> recordList);
}
