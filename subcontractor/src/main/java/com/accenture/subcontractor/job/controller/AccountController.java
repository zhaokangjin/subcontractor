package com.accenture.subcontractor.job.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.common.util.WeixinUtils;
import com.accenture.subcontractor.job.common.util.constant.Constant;
import com.accenture.subcontractor.job.common.util.data.SessionAttribute;
import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;
import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.service.AccountService;
import com.accenture.subcontractor.job.service.UserService;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: AccountController
 * @Description: TODO
 * @author: kangjin.zhao
 * @date:2017年10月26日 下午10:08:03
 */

@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	AccountService accountService;
	@Resource
	UserService userService;

	/**
	 * @Title: registerAccount
	 * @Description: TODO
	 * @param type
	 * @param accountInfo
	 * @param accountInfo
	 *            微信参数
	 *            ：{"subscribe":"1","openid":"oLVPpjqs2BhvzwPj5A-vTYAX4GPG","sex":"M","nickname":"还没开始?","headimgurl":"http://wx.qlogo.cn/mmopen/JcDicrZBlREhnNXZRudod9PmibRkIs5K2f1tUQ7lFjC63pYHaXGxNDgMzjGDEuvzYZbFOqtUXaxSdoZG6iane5ko9H30krIbzGv/0","language":"CN","subscribe_time":"1326160805"}
	 * @throws Exception 
	 * @throws IOException
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@CrossOrigin
	public String register(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 拿到code
		logger.info("AccountController>getWeixinAcount>request:" + request.getParameter("code"));
		String code = request.getParameter("code");
		SessionAttribute sessionAttribute=new SessionAttribute();
		// 获取access_token
		try {
			if (null != code) {
//				if(null!=request.getSession()&&null!=request.getSession().getAttribute("openId")){
//					String session=request.getSession().getAttribute("openId").toString();
//					logger.info("AccountController>getWeixinAccount>existSession:" +session);
//					return session;
//				}
				// 例如：https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1a7ae5e384aa9ca2&secret=88a2fd9c101507007e3fb66c0e206317&code=061472OT11K7781hO2OT16BZNT1472Ow&grant_type=authorization_code
				String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constant.AppId
						+ "&secret=" + Constant.Secret + "&code=" + code + "&grant_type=authorization_code";
				WeixinUtils wu=new WeixinUtils();
				String openIdStr=wu.sendRedirect(getAccessTokenUrl);
				JSONObject tokenObj = JSONObject.fromObject(openIdStr);
				logger.info("AccountController>getWeixinAccount>tokenObj:" +JSON.toJSONString(tokenObj));
				// {"access_token":"f4L3j9GjLtT_Vd0DL_ZFsCAyulRait6sJURoP3oh0MGw2PUmTxb9qL7YkVlyMWvvabqinK6cGLJMUNFRhli0cJTb7Smm-fUUAI_NAtRrIZw","expires_in":7200,"refresh_token":"Fxbfnc6kn7ysz2pIk6BaIjtiUzs8iOSawMYso53aiLkVQfp7p_e7o8zmTb0RjmRAHpkciL84RXowlC_zRyJiG48ZKgA4KZ3wIX_migbem74","openid":"oX5iowJCR5nU2Kiro_I4N9ftMqeA","scope":"snsapi_userinfo"}
				if (null!=tokenObj) {
					Date date=new Date();
					String getUserInfoUrl="https://api.weixin.qq.com/sns/userinfo?access_token="+tokenObj.getString("access_token")+"&openid="+tokenObj.getString("openid")+"&lang=zh_CN";
					String userInfoStr=wu.sendRedirect(getUserInfoUrl);
					JSONObject userObj = JSONObject.fromObject(userInfoStr);
					logger.info("AccountController>getWeixinAccount>userObj:" +JSON.toJSONString(userObj));
					//{"openid":"oX5iowJCR5nU2Kiro_I4N9ftMqeA","nickname":"赵康进","sex":1,"language":"zh_CN","city":"长沙","province":"湖南","country":"中国","headimgurl":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ4MSkGgm6uSdWJibaTKCD4QLZRhY5FgF5artBQzdaicIJribjq2R6qUhFl5sEnJbRXmouYwqzIYNMnQ/0","privilege":[]}
					String openId=userObj.getString("openid");
					Account account=new Account();
					account.setAccountNumberId(openId);
					account.setAccountNumberType("W");
					account.setAccountNumberName(userObj.getString("nickname"));
					account.setCreateTime(date);
					account.setDeleteFlag("Y");
					account.setDescr(userInfoStr);
					account.setPhoto(userObj.getString("headimgurl"));
					AccountKey accountKey=new AccountKey();
					accountKey.setAccountNumberId(openId);
					accountKey.setAccountNumberType("W");
					Account existAccount=accountService.selectByPrimaryKey(accountKey);
					sessionAttribute.setOpenId(openId);
					sessionAttribute.setType("W");
					if(null==existAccount){
						String userId=UUID.randomUUID().toString();
						account.setUserId(userId);
						User user=new User();
						user.setUserId(userId);
						user.setDeleteFlag("Y");
						user.setCreateTime(date);
						accountService.insertSelective(account);
						userService.insert(user);
						logger.info("AccountController>getAccount>existAccount"+JSON.toJSONString(sessionAttribute));
					}else{
						logger.info("AccountController>getAccount>notexistAccount"+JSON.toJSONString(sessionAttribute));
					}
//					request.getSession().setAttribute(openId, sessionAttribute);
					request.getSession().setAttribute("openId", openId);
					request.getSession().setAttribute("type", "W");
					response.sendRedirect("http://liveaboard.cn/#/userInfo?openId="+openId+"&type=W");
					return "openId:"+JSON.toJSONString(sessionAttribute);
				}
			}
		} catch (Exception e) {
			logger.info("AccountController>getAccount>Exception"+e);
			throw e;
		}
		return null;
	}


	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@CrossOrigin
	public  Account getUser(@RequestBody SessionAttribute sessionAttribute, HttpServletRequest request, HttpServletResponse response){
		//oX5iowAOZq4t4CwZ1BgEszbeqO1o
		String openId=sessionAttribute.getOpenId();
		logger.info("AccountController>getAccount>openId:"+openId);
		String type=sessionAttribute.getType();
		logger.info("AccountController>getAccount>type:"+type);
		AccountKey account=new AccountKey();
		Account existAccount=null;
		if(null!=request.getSession()&&null!=request.getSession().getAttribute("openId")){
			
//			account.setAccountNumberId(openId);
//			account.setAccountNumberType(type);
			account.setAccountNumberId(request.getSession().getAttribute("openId").toString());
			account.setAccountNumberType(request.getSession().getAttribute("type").toString());
			existAccount=accountService.selectByPrimaryKey(account);
			logger.info("AccountController>getAccount>existAccount:"+JSON.toJSONString(existAccount));
			String userId=existAccount.getUserId();
			User user=new User();
			user.setUserId(userId);
			User userChild= userService.getUserAndChildren(user);
			existAccount.setUser(userChild);
			if(null!=request.getSession()&&null!=request.getSession().getAttribute(openId)){
				logger.info("AccountController>getAccount>openid:"+openId);
			}
			
			return existAccount;
		}else{
			openId="oX5iowAOZq4t4CwZ1BgEszbeqO1o";
			type="W";
			account.setAccountNumberId(openId);
			account.setAccountNumberType(type);
			existAccount=accountService.selectByPrimaryKey(account);
			logger.info("AccountController>getAccount>openidExistAccount:"+JSON.toJSONString(existAccount));
			return existAccount;
		}
	}
	@RequestMapping(value = "/getWeixinAcount", method = RequestMethod.GET)
	@CrossOrigin
	public void getWeixinAcount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("AccountController>registerAccount>accountInfo:");

	}

}
