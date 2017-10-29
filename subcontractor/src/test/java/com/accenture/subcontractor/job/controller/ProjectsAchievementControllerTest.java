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
import com.accenture.subcontractor.job.domain.ProjectsAchievement;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SubcontractorApp.class)
@WebAppConfiguration
public class ProjectsAchievementControllerTest {
	@Resource
	ProjectsAchievementController projectsAchievementController;

	@Test
	public void test() {
		String id = "430836da-f825-4c4f-a750-c80f36303dbb";
		List<ProjectsAchievement> projectsAchievementList = new ArrayList<ProjectsAchievement>();
		ProjectsAchievement projectsAchievement = null;
		for (int i = 0; i < 23; i++) {
			projectsAchievement = new ProjectsAchievement();
			projectsAchievement.setAchievementDescr("杰出贡献");
			projectsAchievement.setCreateTime(new Date());
			projectsAchievement.setEndDate(new Date());
			projectsAchievement.setProjectAchievementId(UUID.randomUUID().toString());
			projectsAchievement.setProjectResumeId(id);
			projectsAchievement.setStartDate(new Date());
			projectsAchievementList.add(projectsAchievement);
		}
		projectsAchievementController.insertBatch(projectsAchievementList);
	}

}
