package com.accenture.subcontractor.job.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.Certificate;
import com.accenture.subcontractor.job.service.CertificateService;

@RestController
@RequestMapping("certificate")
public class CertificateController {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Resource
	CertificateService certificateService;

	@RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
	public void insertBatch(@RequestBody List<Certificate> recordList) {
		try {
			if(recordList.size()>0){
				certificateService.insertBatch(recordList);
			}
		} catch (Exception e) {
			logger.error("CertificateController>:insertBatch>Exception:"+e);
			throw e;
		}
	}
}
