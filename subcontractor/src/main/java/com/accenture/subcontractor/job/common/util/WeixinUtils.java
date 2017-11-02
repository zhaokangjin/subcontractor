package com.accenture.subcontractor.job.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.subcontractor.job.common.util.constant.Constant;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

public class WeixinUtils {
	private static Logger logger = LoggerFactory.getLogger(WeixinUtils.class);

	public  String refreshAccessToken(String refresh) {
		StringBuffer param = new StringBuffer();

		String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
		param.append("appid=").append(Constant.AppId).append("&grant_type=refresh_token&refresh_token=")
				.append(refresh);
		logger.info("WeixinUtils>refreshAccessToken>url:" + url + ">param" + param);
		String res_body = sendGet(url, param.toString());

		// System.err.println(res_body);
		JSONObject jsObj = JSONObject.fromObject(res_body);
		if (null != jsObj) {
			logger.info("WeixinUtils>refreshAccessToken>jsObj:" + JSON.toJSONString(jsObj));
			return jsObj.get("access_token").toString();
		} else {
			return null;
		}

	}

	public  String[] getWechatUser(String access_token, String openid) {
		StringBuffer param = new StringBuffer();
		String[] args = new String[4];

		String url = "https://api.weixin.qq.com/sns/userinfo";
		param.append("access_token=").append(access_token).append("&openid=").append(openid).append("&lang=zh_CN");

		String res_body = sendGet(url, param.toString());
		// System.err.println(res_body);

		JSONObject object = JSONObject.fromObject(res_body);
		if (null != object) {
			logger.info("WeixinUtils>getWechatUser>object:" + JSON.toJSONString(object));
			args[0] = object.get("openid").toString();
			args[1] = object.get("nickname").toString();
			int i = Integer.parseInt((String) object.get("sex"));
			if (i == 1) {
				args[2] = "M";
			} else if (i == 2) {
				args[2] = "F";
			} else {
				args[2] = "";
			}
			args[3] = object.get("headimgurl").toString();

			return args;

		} else {
			logger.info("WeixinUtils>getWechatUser>object:null");
			return null;
		}

	}

	public  String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			logger.info("WeixinUtils>sendGet>urlNameString:"+urlNameString);
			URL realUrl = new URL(urlNameString);
			logger.info("WeixinUtils>sendGet>realUrl:"+realUrl);
			URLConnection connection = realUrl.openConnection();
			logger.info("WeixinUtils>sendGet>connection:"+connection);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info("WeixinUtils>sendGet>result:"+result);
		} catch (Exception e) {
			logger.info("WeixinUtils>sendGet>Exception"+e);
		}

		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				logger.info("WeixinUtils>sendGet>e2"+e2);
			}
		}
		return result;
	}
}
