package com.security.springSecurityExample.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.security.springSecurityExample.base.TranResponse;
import com.security.springSecurityExample.enums.ReturnCode;
import com.security.springSecurityExample.exception.DataNotFoundException;
import com.security.springSecurityExample.util.TranResponseFactory;

@RestControllerAdvice
public class WebExceptionHandler {
	
	@Autowired
	private TranResponseFactory tranResponseFactory;

	/** DataNotFoundException */
	@ExceptionHandler(value = DataNotFoundException.class)
	public <T> TranResponse<T> handleDataNotFoundException(){
		return tranResponseFactory.genFailResponse(null, ReturnCode.C002);
	}
}
