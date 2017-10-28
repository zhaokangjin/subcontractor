package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDesc;

public interface ProjectsDescService {

	public abstract void insertBatch(List<ProjectsDesc> projectsDescList);

}
