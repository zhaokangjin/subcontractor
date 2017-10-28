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
import com.accenture.subcontractor.job.domain.ProjectsDuty;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SubcontractorApp.class)
@WebAppConfiguration
public class ProjectsDutyControllerTest {
	@Resource
	ProjectsDutyController projectsDutyController;

	@Test
	public void test() {
		String id="430836da-f825-4c4f-a750-c80f36303dbb";
		List<ProjectsDuty> projectsDutyList=new ArrayList<ProjectsDuty>();
		ProjectsDuty projectsDuty=null;
		for(int i=0;i<9;i++){
			projectsDuty=new ProjectsDuty();
			projectsDuty.setCreateTime(new Date());
			projectsDuty.setDepartment("财务部");
			projectsDuty.setEndDate(new Date());
			projectsDuty.setPost("会计");
			projectsDuty.setProjectResponsibilityId(UUID.randomUUID().toString());
			projectsDuty.setProjectResumeId(id);
			projectsDuty.setResponsibilityDescr("发钱"+i);
			projectsDuty.setStartDate(new Date());
			projectsDutyList.add(projectsDuty);
		}
		projectsDutyController.insertBatch(projectsDutyList);
	}

}
