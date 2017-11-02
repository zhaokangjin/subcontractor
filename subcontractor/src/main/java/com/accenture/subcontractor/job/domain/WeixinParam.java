package com.accenture.subcontractor.job.domain;

import java.util.Map;

public class WeixinParam {
	private String type;
	private Map<String, String> param;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}
}
