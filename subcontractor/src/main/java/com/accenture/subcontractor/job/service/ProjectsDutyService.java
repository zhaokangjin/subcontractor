package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDuty;

public interface ProjectsDutyService {

	public abstract void insertBatch(List<ProjectsDuty> recordList);

}
