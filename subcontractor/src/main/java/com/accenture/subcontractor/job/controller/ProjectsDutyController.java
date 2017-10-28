package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.ProjectsDuty;
import com.accenture.subcontractor.job.service.ProjectsDutyService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("projectsDuty")
public class ProjectsDutyController {
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsDutyService projectsDutyService;
	
	@RequestMapping(value="insertBatch",method=RequestMethod.POST)
	public void insertBatch(@RequestBody List<ProjectsDuty> recordList){
		logger.info("ProjectsDutyController>insertBatch>recordList:"+JSON.toJSONString(recordList));
		try {
			if(null!=recordList && recordList.size()>0){
				projectsDutyService.insertBatch(recordList);
			}
		} catch (Exception e) {
			logger.error("ProjectsDutyController>insertBatch>Exception:"+e);
		}
	}
}
