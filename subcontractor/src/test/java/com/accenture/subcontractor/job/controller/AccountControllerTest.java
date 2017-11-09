package com.accenture.subcontractor.job.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;
import com.accenture.subcontractor.job.domain.Account;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SubcontractorApp.class)
@WebAppConfiguration
public class AccountControllerTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	AccountController accountController;

	@Test
	public void test() {
//		Account account=new Account();
//		account.setAccountNumberId("oX5iowJCR5nU2Kiro_I4N9ftMqeA");
//		account.setAccountNumberType("W");
//		Account accountType =accountController.getAccount(account);
//		logger.error("accountType:"+JSON.toJSONString(accountType));
	}

}
