package com.accenture.subcontractor.job.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;
import com.accenture.subcontractor.job.common.util.data.Page;
import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.condition.SkillTypeConditon;
import com.alibaba.fastjson.JSON;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SubcontractorApp.class)
@WebAppConfiguration
public class SkillTypeControllerTest {
	Logger logger =LoggerFactory.getLogger(this.getClass());
	@Resource
	SkillTypeController skillTypeController;
	@Test
	public void test() {
		List<SkillType> recordList=new ArrayList<SkillType>();
		SkillType skill=null;
		for(int i=8;i<12;i++){
			skill=new SkillType();
			if((i+1)>=10){
				skill.setSkillId("0"+(i+1));
			}else{
				skill.setSkillId("00"+(i+1));
			}
			recordList.add(skill);
		}
		List<SkillType> recordList1=skillTypeController.listSkillByIDs(recordList);
		logger.info("SkillTypeControllerTest>SkillType:"+JSON.toJSONString(recordList1));
	}
	@Test
	public void getRoot(){
		
		SkillTypeConditon skillTypeConditon=new SkillTypeConditon();
		Page page=new Page();
		page.setPageNum(1);
		page.setPageSize(4);
		skillTypeConditon.setPage(page);
		SkillType skillType=new SkillType();
		skillType.setLevel("1");
		skillTypeConditon.setSkillTyp(skillType);
		Object obj=skillTypeController.querySkillRootList(skillTypeConditon);
		logger.info("SkillTypeControllerTest>getRoot:"+JSON.toJSONString(obj));
	}
	@Test
	public void getSkillTypeByName(){
		

		SkillType skillType=new SkillType();
		skillType.setLevel("1");
		
		Object obj=skillTypeController.selectByName("Spring");
		logger.info("SkillTypeControllerTest>getSkillTypeByName:"+JSON.toJSONString(obj));
	}
}
