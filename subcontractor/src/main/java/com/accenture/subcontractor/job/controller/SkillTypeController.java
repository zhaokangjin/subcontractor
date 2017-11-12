package com.accenture.subcontractor.job.controller;

import java.util.List;

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

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
	public SkillType selectByPrimaryKey(@RequestParam("skillType") String skillId) {
		SkillType skillType = skillTypeService.selectByPrimaryKey(skillId);
		return skillType;
	}
	@RequestMapping(value = "/selectByName", method = RequestMethod.POST)
	public List<SkillType> selectByName(@RequestParam("skillName") String skillName) {
		try {
			List<SkillType> skillType = skillTypeService.selectSkillTypeByName(skillName);
			return skillType;
		} catch (Exception e) {
			logger.error("SkillTypeController>selectByName>Exception"+e);
			throw e;
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody SkillType skillType) {
		try {
			skillTypeService.insert(skillType);
		} catch (Exception e) {
			logger.error("SkillTypeController>insert>Exception"+e);
			throw e;
		}
	}
	
	@RequestMapping(value="/queryListByIDs",method=RequestMethod.POST)
	public List<SkillType> listSkillByIDs(@RequestBody List<SkillType> recordList){
		try {
			return skillTypeService.queryListByIds(recordList);
		} catch (Exception e) {
			logger.error("SkillTypeController>listSkillByIDs>Exception"+e);
			throw e;
		}
	}
	@RequestMapping(value="/listChildSkill",method=RequestMethod.POST)
	public List<SkillType> listChildSkill(@RequestBody SkillType skillType){
		try {
			if(null!=skillType&&null!=skillType.getSkillId()){
				return skillTypeService.listChildSkill(skillType.getSkillId());
			}else{
				throw new NullPointerException("SkillTypeController>listChildSkill>skillType.getSkillId()=null");
			}
		} catch (Exception e) {
			logger.error("SkillTypeController>listChildSkill>Exception"+e);
			throw e;
		}
	}
	@RequestMapping(value = "/querySkillRootList", method = RequestMethod.POST)
	public PageInfo<SkillType> querySkillRootList(@RequestBody SkillTypeConditon skillTypeConditon){
		try {
			PageInfo<SkillType> pageDta=skillTypeService.querySkillRootList(skillTypeConditon);
			return pageDta;
		} catch (Exception e) {
			logger.error("SkillTypeController>queryList>Exception"+e);
			throw e;
		}
	}
}
