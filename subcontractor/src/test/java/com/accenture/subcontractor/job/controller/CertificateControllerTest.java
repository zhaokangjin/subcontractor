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
import com.accenture.subcontractor.job.domain.Certificate;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SubcontractorApp.class)
@WebAppConfiguration
public class CertificateControllerTest {
@Resource
CertificateController certificateController;
	@Test
	public void test() {
		String id=UUID.randomUUID().toString();
		List<Certificate> certificateList=new ArrayList<Certificate>();
		Certificate certificate=null;
		for(int i=0;i<23;i++){
			 certificate=new Certificate();
			 certificate.setAwardDate(new Date(2017,6,30));
			 certificate.setAwardOrgan("中华人民共和国教育部");
			 certificate.setCertificateCode("dddddd"+i);
			 certificate.setCertificateName("学位证书");
			 certificate.setCertificateType("全日制");
			 certificate.setCreateTime(new Date());
			 certificate.setEducationResumeId(id);
			 certificate.setCertificateId(UUID.randomUUID().toString());
			 certificateList.add(certificate);
		}
		certificateController.insertBatch(certificateList);
	}

}
