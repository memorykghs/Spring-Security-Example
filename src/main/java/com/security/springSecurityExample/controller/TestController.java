package com.security.springSecurityExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Recommend Book And Movies")
@RestController
public class TestController {
	
	@ApiOperation(value = "測試")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test success";
	}

//	@ApiOperation(value = "登入")
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestBody UserInfo req) {
//		return "login success";
//	}
}
