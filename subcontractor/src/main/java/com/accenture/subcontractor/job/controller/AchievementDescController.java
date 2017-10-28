package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.AchievementDesc;
import com.accenture.subcontractor.job.service.AchievementDescService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("achievementDesc")
public class AchievementDescController {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Resource
	AchievementDescService achievementDescService;

	@RequestMapping(value = "/insertBach", method = RequestMethod.POST)
	public void insertBatch(@RequestBody List<AchievementDesc> recordList) {
		logger.info("AchievementDescController>insertBatch>recordList:"+JSON.toJSONString(recordList));
		try {
			if(null!=recordList&& recordList.size()>0){
				achievementDescService.insertBatch(recordList);
			}
		} catch (Exception e) {
			logger.error("AchievementDescController>insertBatch>Exception:"+e);
			throw e;
		}
	}

}
