package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.dao.AreaDao;
import com.springboot.demo.entity.Area;
import com.springboot.demo.service.AreaService;
import com.springboot.demo.service.impl.AreaServiceImpl;

@RestController
@RequestMapping("/admin")
public class AreaController {
	@Autowired
	private AreaService as;
	@RequestMapping(value="/listarea",method = RequestMethod.GET)
	private HashMap<String,Object> listArea(){
		HashMap<String,Object> areaMap = new HashMap<String, Object>();
		List<Area> alist = as.getAreas();
		areaMap.put("areaList", alist);
		return areaMap;
	}
	
	@RequestMapping(value="/getarea",method = RequestMethod.GET)
	private Area getAreaById(int id) {
		
	}
	

}
