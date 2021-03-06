package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.common.util.constant.Status;
import com.accenture.subcontractor.job.domain.Skill;
import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.StatusCode;
import com.accenture.subcontractor.job.domain.condition.SkillCondition;
import com.accenture.subcontractor.job.service.SkillService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("skill")
public class SkillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	SkillService skillService;

	@RequestMapping(value = "/getSkillsByUserId", method = RequestMethod.POST)
	public PageInfo<Skill> getSkillsByUserId(@RequestBody SkillCondition skillCondition) {
		logger.info("SkillController>selectByUserId>skill:" + JSON.toJSONString(skillCondition));
		try {
			if (skillCondition != null) {
				return skillService.selectByUserId(skillCondition);
			}
			return null;
		} catch (Exception e) {
			logger.error("SkillController>selectByUserId>Exception:" + e);
			throw e;
		}
	}

	@RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
	public StatusCode insertOrUpdate(@RequestBody List<Skill> recordList) {
		logger.info("SkillController>insertOrUpdate>skill:" + JSON.toJSONString(recordList));
		StatusCode statusCode = new StatusCode();
		try {
			if (recordList != null && recordList.size() > 0) {
				skillService.insertOrUpdate(recordList);
			}
			statusCode.setCode(Status.SUCCSESS_CODE);
			statusCode.setCode(Status.SUCCSESS_STATUS);
			return statusCode;
		} catch (Exception e) {
			logger.error("SkillController>selectByUserId>Exception:" + e);
			throw e;
		}
	}
}
