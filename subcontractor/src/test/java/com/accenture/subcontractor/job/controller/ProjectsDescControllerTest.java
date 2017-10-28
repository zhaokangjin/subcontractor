package com.accenture.subcontractor.job.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;
import com.accenture.subcontractor.job.domain.ProjectsDesc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SubcontractorApp.class)
@WebAppConfiguration
public class ProjectsDescControllerTest {
	@Resource
	ProjectsDescController projectsDescController;

	@Test
	public void test() {
		String id = UUID.randomUUID().toString();
		List<ProjectsDesc> projectsDescList = new ArrayList<ProjectsDesc>();
		ProjectsDesc projectsDesc=null;
		for(int i=0;i<12;i++){
			projectsDesc=new ProjectsDesc();
			projectsDesc.setCreateTime(new Date());
			projectsDesc.setEndDate(new Date());
			projectsDesc.setProjectDescr(i+":这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目这是一个很感人的项目");
			projectsDesc.setProjectDescrId(UUID.randomUUID().toString());
			projectsDesc.setProjectResumeId(id);
			projectsDesc.setStartDate(new Date());
			projectsDescList.add(projectsDesc);
		}
		projectsDescController.insertBatch(projectsDescList);
	}

}
