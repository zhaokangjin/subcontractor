package com.accenture.subcontractor.job.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.common.util.WeixinUtils;
import com.accenture.subcontractor.job.common.util.constant.Constant;
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
	 *            微信参数
	 *            ：{"subscribe":"1","openid":"oLVPpjqs2BhvzwPj5A-vTYAX4GPG","sex":"M","nickname":"还没开始?","headimgurl":"http://wx.qlogo.cn/mmopen/JcDicrZBlREhnNXZRudod9PmibRkIs5K2f1tUQ7lFjC63pYHaXGxNDgMzjGDEuvzYZbFOqtUXaxSdoZG6iane5ko9H30krIbzGv/0","language":"CN","subscribe_time":"1326160805"}
	 * @throws IOException 
	 */

	@RequestMapping(value = "/getWeixinAcount", method = RequestMethod.GET)
	@CrossOrigin
	public Account getWeixinAccount(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		WeixinUtils weixinUtils =new WeixinUtils();
		StringBuffer sb = new StringBuffer();

		String access_token = weixinUtils.refreshAccessToken(request.getParameter("refresh_token"));

		String[] args = weixinUtils.getWechatUser(access_token, request.getParameter("openid"));

		String url = URLEncoder.encode(args[3], "UTF-8");
		url = url.replaceAll("%5c", "");

		Cookie cookie = new Cookie("dianjing", "wechat");
		cookie.setDomain("djb.liveaboard.cn");
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		Account account = new Account();
		account.setAccountNumberName(args[1]);
		account.setAccountNumberId(args[0]);
		sb.append("http://djb.liveaboard.cn/DottingRegister/index.html?").append("oid=").append(args[0]).append("&")
				.append("nick=").append(args[1]).append("&").append("sex=").append(args[2]).append("&").append("iurl=")
				.append(url);

		response.sendRedirect(sb.toString());
		return account;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@CrossOrigin
	public int registerAccount(@RequestBody WeixinParam weixinParam, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("AccountController>registerAccount>accountInfo:" + JSON.toJSONString(weixinParam));
		StringBuffer param = new StringBuffer();
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize";
		// 需要跳转到startpage页面，加当前按钮选择的参数
		param.append("appid=").append(Constant.AppId).append("&redirect_uri=")
				.append(URLEncoder.encode("http://liveaboard.cn:26500/portal/app/index.html", "UTF-8"))
				.append("&response_type=code&scope=snsapi_userinfo&state=dianjing#wechat_redirect");

		// logger.info("AccountController>registerAccount>code:"+code+">listId:"+listId+">"+playId);
		String type = weixinParam.getType();
		Map<String, String> accountInfo = weixinParam.getParam();
		if (!StringUtils.isEmpty(type) && null != accountInfo) {
			try {
				Account account = new Account();
				if (type.equals("weixin")) {

					account.setAccountNumberId(MapUtils.getString(accountInfo, "openid", ""));
					account.setAccountNumberType("W");
					account.setPhoto(MapUtils.getString(accountInfo, "photo", ""));
					account.setDescr(JSON.toJSONString(accountInfo));
					account.setRegisterAddress(MapUtils.getString(accountInfo, "city", ""));
					account.setDeleteFlag("N");
					account.setCreateTime(new Date());
					account.setAccountNumberName(MapUtils.getString(accountInfo, "nickname", ""));
					accountService.register(account);
					String redirectUrl=url + "?" + param.toString();
					logger.info("WeixinParam>registerAccount>redirectUrl:"+redirectUrl);
					response.sendRedirect(redirectUrl);
					return 1;
				}
				return 0;
			} catch (Exception e) {
				logger.error("AccountController>registerAccount>Exception:" + e);
				throw e;
			}
		} else {
			throw new NullPointerException("type and accountInfo must not be null");
		}
	}
}
