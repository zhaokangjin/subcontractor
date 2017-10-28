package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.WorkContent;
import com.accenture.subcontractor.job.service.WorkContentService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("workContent")
public class WorkContentController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	WorkContentService workContentService;
	@RequestMapping(value="deleteBatch",method=RequestMethod.POST)
	public void deleteBatch(@RequestBody List<WorkContent> recordList) {
		workContentService.deleteBatch(recordList);
	}
	/**
	 * @Title: insertBatch   
	 * @Description: TODO  
	 * @param recordList [{"contentId":"5f86e511-28b9-43c9-8950-2a889a0ee9c6","createTime":1509176449883,"departmentName":"财务共享中心0","endDate":61464931200000,"post":"会计0","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462339200000,"workContent":"加工资"},{"contentId":"cc51e8d1-0823-48fc-8a60-ad9ab7e7621a","createTime":1509176449883,"departmentName":"财务共享中心1","endDate":61465017600000,"post":"会计1","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462425600000,"workContent":"加工资"},{"contentId":"d4be43f8-5b95-469e-bd8f-eeb3afd8322e","createTime":1509176449884,"departmentName":"财务共享中心2","endDate":61465104000000,"post":"会计2","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462512000000,"workContent":"加工资"},{"contentId":"a6953d26-f7a2-4e0d-b693-a96fc1f46179","createTime":1509176449884,"departmentName":"财务共享中心3","endDate":61465190400000,"post":"会计3","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462598400000,"workContent":"加工资"},{"contentId":"f04e74db-22b4-4151-9e18-044494b5963e","createTime":1509176449884,"departmentName":"财务共享中心4","endDate":61465276800000,"post":"会计4","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462684800000,"workContent":"加工资"},{"contentId":"bc6d211f-f5a6-4c89-a070-00acf13c26c6","createTime":1509176449884,"departmentName":"财务共享中心5","endDate":61465363200000,"post":"会计5","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462771200000,"workContent":"加工资"},{"contentId":"13e0ec7f-169b-4708-ae6e-117212de049a","createTime":1509176449884,"departmentName":"财务共享中心6","endDate":61465449600000,"post":"会计6","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462857600000,"workContent":"加工资"},{"contentId":"256a7972-1142-4559-8caa-0d6e002dc480","createTime":1509176449884,"departmentName":"财务共享中心7","endDate":61465536000000,"post":"会计7","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61462944000000,"workContent":"加工资"},{"contentId":"e784c710-13b5-41d8-a09f-c7604213090a","createTime":1509176449884,"departmentName":"财务共享中心8","endDate":61465622400000,"post":"会计8","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61463030400000,"workContent":"加工资"},{"contentId":"3111bf41-51ae-4f8d-9bc8-ee947ad54060","createTime":1509176449884,"departmentName":"财务共享中心9","endDate":61465708800000,"post":"会计9","resumeId":"18d517e0-d986-4251-81e9-679e01ab2184","startDate":61463116800000,"workContent":"加工资"}]
	 */
	public void insertBatch(@RequestBody List<WorkContent> recordList) {
		logger.info("WorkContentController>insertBatch>recordList:"+JSON.toJSONString(recordList));
		try {
			if(recordList.size()>0){
				workContentService.insertBatch(recordList);
			}
		} catch (Exception e) {
			logger.error("WorkContentController>insertBatch>Exception:"+e);
			throw e;
		}
	}
	public void updateBatch(@RequestBody List<WorkContent> recordList) {
		workContentService.insertBatch(recordList);
	}
}
