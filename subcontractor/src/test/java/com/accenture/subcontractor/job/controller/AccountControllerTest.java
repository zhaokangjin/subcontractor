package com.accenture.subcontractor.job.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = SubcontractorApp.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class AccountControllerTest {
	@Resource
	AccountController accountController;

	@Test
	public void test() {
		Map<String,String> accountInfo=new HashMap<String,String>();
		/*
		 * 	 *            微信参数 { "subscribe": 1, "openid":
	 *            "oLVPpjqs2BhvzwPj5A-vTYAX4GLc", "nickname": "刺猬宝宝", "sex": 1,
	 *            "language": "zh_CN", "city": "深圳", "province": "广东",
	 *            "country": "中国", "headimgurl":
	 *            "http://wx.qlogo.cn/mmopen/JcDicrZBlREhnNXZRudod9PmibRkIs5K2f1tUQ7lFjC63pYHaXGxNDgMzjGDEuvzYZbFOqtUXaxSdoZG6iane5ko9H30krIbzGv/0",
	 *            "subscribe_time": 1386160805 }
		 */
		
		accountInfo.put("subscribe", "1");
		accountInfo.put("openid", "oLVPpjqs2BhvzwPj5A-vTYAX4GPG");
		accountInfo.put("nickname", "还没开始?");
		accountInfo.put("sex", "M");
		accountInfo.put("language", "CN");
		accountInfo.put("headimgurl", "http://wx.qlogo.cn/mmopen/JcDicrZBlREhnNXZRudod9PmibRkIs5K2f1tUQ7lFjC63pYHaXGxNDgMzjGDEuvzYZbFOqtUXaxSdoZG6iane5ko9H30krIbzGv/0");
		accountInfo.put("subscribe_time", "1326160805");
		accountController.registerAccount("weixin", accountInfo);
	}

}
