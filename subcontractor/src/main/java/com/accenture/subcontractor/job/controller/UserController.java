package com.accenture.subcontractor.job.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.service.AccountService;
import com.accenture.subcontractor.job.service.UserService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserService userService;
	@Resource
	AccountService accountService;
	@RequestMapping(value="/getUserAndChild",method=RequestMethod.GET)
	public User getUserAndChild(Account account){
		if(null!=account){
			logger.info("UserController>getUserAndChild>account:"+JSON.toJSONString(account));
			Account registerAccount=accountService.selectByPrimaryKey(account);
			String userId=registerAccount.getUserId();
			User user=new User();
			user.setUserId(userId);
			return userService.getUserAndChildren(user);
		}else{
			throw new NullPointerException("UserController>getUserAndChild>account:NullPointerException");
		}
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void saveUserAndChildren(User user){
		if(null!=user){
			logger.info("UserController>getUserAndChild>account:"+JSON.toJSONString(user));
			userService.saveOrUpdateUser(user);
			
		}else{
			throw new NullPointerException("新增用户信息数据空指针异常");
		}
	}
	
	
}
