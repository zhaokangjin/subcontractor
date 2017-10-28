package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.ProjectsDesc;
import com.accenture.subcontractor.job.service.ProjectsDescService;
@RestController
@RequestMapping("projectsDesc")
public class ProjectsDescController {
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsDescService projectsDescService;
	
	@RequestMapping(value="/insertBatch",method=RequestMethod.POST)
	public void insertBatch(@RequestBody List<ProjectsDesc> projectsDescList){
		try {
			if(null!=projectsDescList&&projectsDescList.size()>0){
				projectsDescService.insertBatch(projectsDescList);
			}
		} catch (Exception e) {
			logger.error("ProjectsDescController>insertBatch>Exception:"+e);
			throw e;
		}
	}
}
