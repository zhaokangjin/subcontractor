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
import com.accenture.subcontractor.job.domain.WorkContent;
import com.accenture.subcontractor.job.domain.WorkResume;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SubcontractorApp.class)
@WebAppConfiguration
public class WorkResumeControllerTest {
	@Resource
	WorkResumeController workResumeController;

	@Test
	public void test() {
		List<WorkResume> workResumeList = new ArrayList<WorkResume>();
		WorkResume workResume = null;
		String userId = UUID.randomUUID().toString();
		for (int i = 0; i < 20; i++) {
			String flag = genFlag(i);
			workResume = genWorkResume(flag, i, userId);
			workResumeList.add(workResume);
		}
		workResumeController.editBatch(workResumeList);
	}

	private WorkResume genWorkResume(String deleteFlag, int index, String userId) {
		WorkResume workResume = new WorkResume();
		workResume.setDeleteFlag(deleteFlag);
		// workResume.setCreateTime(new Date());
		String resumeId = UUID.randomUUID().toString();
		workResume.setResumeId(resumeId);
		workResume.setCompanyName("浙江能源");
		workResume.setCreator("yumiao");
		workResume.setUserId(userId);
		workResume.setEntryDate(new Date());
		workResume.setQuitDate(new Date());
		workResume.setTitleRank("开发"+index);
		List<WorkContent> workContentList = new ArrayList<WorkContent>();
		for (int k = 3; k < 39; k++) {
			String flag = genFlag(k);
			workContentList.add(genWorkConten(flag, k, resumeId));
		}

		workResume.setWorkContentList(workContentList);
		return workResume;
	}

	private WorkContent genWorkConten(String flag, int k, String resumeId) {
		WorkContent workContent = new WorkContent();
		workContent.setDeleteFlag(flag);
		workContent.setContentId(UUID.randomUUID().toString());
		workContent.setResumeId(resumeId);
		workContent.setDepartmentName("财经中心"+k);
		workContent.setEndDate(new Date());
		workContent.setPost("经理"+k);
		workContent.setStartDate(new Date());
		workContent.setWorkContent("苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农苦逼的码农");
		return workContent;
	}

	private String genFlag(int i) {
		int type = i % 5;
		String flag = null;
		if (type == 0) {
			flag = "N";
		}
		if (type == 1) {
			flag = "Y";
		}
		if (type == 2) {
			flag = "U";
		}
		if (type == 3) {
			flag = "S";
		}

		return flag;
	}
}
