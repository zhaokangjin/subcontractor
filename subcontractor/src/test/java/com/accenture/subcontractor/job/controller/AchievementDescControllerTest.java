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
import com.accenture.subcontractor.job.domain.AchievementDesc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SubcontractorApp.class)
@WebAppConfiguration
public class AchievementDescControllerTest {
	@Resource
	AchievementDescController achievementDescController;

	@Test
	public void test() {
		String id = UUID.randomUUID().toString();
		List<AchievementDesc> achievementDescList = new ArrayList<AchievementDesc>();
		AchievementDesc achievementDesc = null;
		for (int i = 0; i < 30; i++) {
			achievementDesc = new AchievementDesc();
			achievementDesc.setAchievementDescr("成绩合格" + i);
			achievementDesc.setAchievementId(UUID.randomUUID().toString());
			achievementDesc.setAchievementName("高等数学");
			achievementDesc.setCreateTime(new Date());
			achievementDesc.setEducationResumeId(id);
			achievementDesc.setEndDate(new Date(2016, 1, 1));
			achievementDesc.setStartDate(new Date(2016, 6, 1));
			achievementDescList.add(achievementDesc);
		}
		achievementDescController.insertBatch(achievementDescList);
	}
}
