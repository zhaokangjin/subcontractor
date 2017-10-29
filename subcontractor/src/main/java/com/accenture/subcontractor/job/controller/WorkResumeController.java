package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.WorkResume;
import com.accenture.subcontractor.job.service.WorkResumeService;

@RestController
@RequestMapping("workResume")
public class WorkResumeController {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Resource 
	private WorkResumeService workResumeService;
	
	@RequestMapping(value="editBatch",method=RequestMethod.POST)
	public void editBatch(@RequestBody List<WorkResume> workResumeList){
		try {
			if(null!=workResumeList&& workResumeList.size()>0){
				workResumeService.editBatch(workResumeList);
			}
		} catch (Exception e) {
			logger.error("WorkResumeController>editBatch>Exception:"+e);
			throw e;
		}
	}
}
