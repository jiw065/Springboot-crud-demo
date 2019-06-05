package com.springboot.demo.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
		Map<String,Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", false); //cuase the exception happens, so it has to be false
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
	
}
