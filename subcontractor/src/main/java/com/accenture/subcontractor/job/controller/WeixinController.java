package com.accenture.subcontractor.job.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weixin")
public class WeixinController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void register(@RequestParam("userInfo") Map<String,String> userInfo){
		
	}

}
