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

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = SubcontractorApp.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class WorkContentControllerTest {
	@Resource
	WorkContentController workContentController;

	@Test
	public void test() {
		List<WorkContent> recordList= new ArrayList<WorkContent>();
		WorkContent workContent=null;
		String resumeId=UUID.randomUUID().toString();
		for(int i=0;i<10;i++){
			workContent=new WorkContent();
			workContent.setContentId(UUID.randomUUID().toString());
			workContent.setCreateTime(new Date());
			workContent.setDepartmentName("财务共享中心"+i);
			workContent.setStartDate(new Date(2017,8,1+i));
			workContent.setEndDate(new Date(2017,9,1+i));
			workContent.setResumeId(resumeId);
			workContent.setPost("会计"+i);
			workContent.setWorkContent("加工资");
			recordList.add(workContent);
		}
		workContentController.insertBatch(recordList);
	}

}
