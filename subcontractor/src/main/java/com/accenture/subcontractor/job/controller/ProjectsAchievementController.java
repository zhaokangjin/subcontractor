package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.ProjectsAchievement;
import com.accenture.subcontractor.job.service.ProjectsAchievementService;

@RestController
@RequestMapping("projectsAchievement")
public class ProjectsAchievementController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsAchievementService projectsAchievementService;
	
	@RequestMapping(value="/insertBatch",method=RequestMethod.POST)
	public void insertBatch(@RequestBody List<ProjectsAchievement> projectsAchievementList){
		try {
			if(projectsAchievementList.size()>0){
				projectsAchievementService.insertBatch(projectsAchievementList);
			}
		} catch (Exception e) {
			logger.error("ProjectsAchievementController>insertBatch>Exception:"+e);
			throw e;
		}
	}
}
