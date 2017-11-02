package com.accenture.subcontractor.job.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.WeixinParam;
import com.accenture.subcontractor.job.service.AccountService;
import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: AccountController
 * @Description: TODO
 * @author: kangjin.zhao
 * @date:2017年10月26日 下午10:08:03
 */

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	AccountService accountService;

	/**
	 * @Title: registerAccount
	 * @Description: TODO
	 * @param type
	 * @param accountInfo
	 * @param accountInfo
	 *  微信参数 ：{"subscribe":"1","openid":"oLVPpjqs2BhvzwPj5A-vTYAX4GPG","sex":"M","nickname":"还没开始?","headimgurl":"http://wx.qlogo.cn/mmopen/JcDicrZBlREhnNXZRudod9PmibRkIs5K2f1tUQ7lFjC63pYHaXGxNDgMzjGDEuvzYZbFOqtUXaxSdoZG6iane5ko9H30krIbzGv/0","language":"CN","subscribe_time":"1326160805"}
	 */
	
	@RequestMapping(value="/getRegister",method=RequestMethod.GET)
	@CrossOrigin
	public List<Account> getAccount(@RequestBody Account account) {
//		String id="018606e4-079b-4441-a372-98cded8c6142";
		return accountService.selectAccountByUserId(account.getUserId());
//		logger.info("AccountController>registerAccount>accountInfo:"+JSON.toJSONString(weixinParam));
//		String type=weixinParam.getType();
//		Map<String,String> accountInfo=weixinParam.getParam();
//		if (!StringUtils.isEmpty(type)&& null!=accountInfo) {
//			try {
//				Account account = new Account();
//				if (type.equals("weixin")) {
//					
//					account.setAccountNumberId(MapUtils.getString(accountInfo, "openid", ""));
//					account.setAccountNumberType("W");
//					account.setPhoto( MapUtils.getString(accountInfo, "photo", ""));
//					account.setDescr(JSON.toJSONString(accountInfo));
//					account.setRegisterAddress(MapUtils.getString(accountInfo, "city", ""));
//					account.setDeleteFlag("N");
//					account.setCreateTime(new Date());
//					account.setAccountNumberName(MapUtils.getString(accountInfo, "nickname", ""));
//					accountService.register(account);
//					return 1;
//				}
//				return 0;
//			} catch (Exception e) {
//				logger.error("AccountController>registerAccount>Exception:"+e);
//				throw e;
//			}
//		} else {
//			throw new NullPointerException("type and accountInfo must not be null");
//		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@CrossOrigin
	public int registerAccount(@RequestBody WeixinParam weixinParam) {
		logger.info("AccountController>registerAccount>accountInfo:"+JSON.toJSONString(weixinParam));
		String type=weixinParam.getType();
		Map<String,String> accountInfo=weixinParam.getParam();
		if (!StringUtils.isEmpty(type)&& null!=accountInfo) {
			try {
				Account account = new Account();
				if (type.equals("weixin")) {
					
					account.setAccountNumberId(MapUtils.getString(accountInfo, "openid", ""));
					account.setAccountNumberType("W");
					account.setPhoto( MapUtils.getString(accountInfo, "photo", ""));
					account.setDescr(JSON.toJSONString(accountInfo));
					account.setRegisterAddress(MapUtils.getString(accountInfo, "city", ""));
					account.setDeleteFlag("N");
					account.setCreateTime(new Date());
					account.setAccountNumberName(MapUtils.getString(accountInfo, "nickname", ""));
					accountService.register(account);
					return 1;
				}
				return 0;
			} catch (Exception e) {
				logger.error("AccountController>registerAccount>Exception:"+e);
				throw e;
			}
		} else {
			throw new NullPointerException("type and accountInfo must not be null");
		}
	}
}
