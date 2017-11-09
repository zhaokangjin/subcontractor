package com.accenture.subcontractor.job.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.condition.SkillTypeConditon;
import com.accenture.subcontractor.job.service.SkillTypeService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("skillType")
public class SkillTypeController {
	private static Logger logger =LoggerFactory.getLogger(SkillTypeController.class);
	@Resource
	SkillTypeService skillTypeService;

	@RequestMapping(value = "/getSkillType", method = RequestMethod.POST)
	public SkillType getSkillType(@RequestParam("skillType") String skillId) {
		SkillType skillType = skillTypeService.selectByPrimaryKey(skillId);
		return skillType;
	}
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public PageInfo<SkillType> queryList(@RequestBody SkillTypeConditon skillTypeConditon) {
		try {
			PageInfo<SkillType> pageDta=skillTypeService.queryList(skillTypeConditon);
			return pageDta;
		} catch (Exception e) {
			logger.error("SkillTypeController>queryList>Exception"+e);
			throw e;
		}
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody SkillType skillType) {
		skillTypeService.insert(skillType);
	}
}
