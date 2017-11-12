package com.accenture.subcontractor.job.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;
import com.accenture.subcontractor.job.domain.Skill;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SubcontractorApp.class)
@WebAppConfiguration
public class SkillControllerTest {
	@Resource
	SkillController skillController;

	@Test
	public void testInsertOrUpdate() {
		List<Skill> recordList=new ArrayList<Skill>();

		Skill skill1=new Skill();
		skill1.setUserId("f9da2af9-3eae-41d8-aeac-097f4dc75125");
		skill1.setSkillId("8ac6e0cb-c7a5-11e7-b5d3-00163e12ae01");
		recordList.add(skill1);
		Skill skill2=new Skill();
		skill2.setUserId("f9da2af9-3eae-41d8-aeac-097f4dc75125");
		skill2.setSkillId("8ac6dc5a-c7a5-11e7-b5d3-00163e12ae01");
		recordList.add(skill2);
		skillController.insertOrUpdate(recordList);
	}

}
