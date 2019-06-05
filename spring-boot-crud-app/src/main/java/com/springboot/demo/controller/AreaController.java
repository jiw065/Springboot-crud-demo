package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/getareabyid",method = RequestMethod.GET)
	private HashMap<String,Object> getAreaById(int id) {
		HashMap<String,Object> areaMap = new HashMap<String, Object>();
		Area a = as.getAreaById(id);
		areaMap.put("area", a);
		return areaMap;
	}
	
	@RequestMapping(value="/addarea",method = RequestMethod.POST)
	private HashMap<String,Object> addArea(@RequestBody Area a){
		HashMap<String,Object> areaMap = new HashMap<String, Object>();
		areaMap.put("success", as.addArea(a));
		return areaMap;
	}
	
	@RequestMapping(value="/updatearea",method = RequestMethod.POST)
	private HashMap<String,Object> modifyArea(@RequestBody Area a){
		HashMap<String,Object> areaMap = new HashMap<String, Object>();
		areaMap.put("success", as.updateArea(a));
		return areaMap;
	}
	
	@RequestMapping(value="/deletearea",method = RequestMethod.GET)
	private HashMap<String,Object> modifyArea(int id){
		HashMap<String,Object> areaMap = new HashMap<String, Object>();
		areaMap.put("success", as.deleteArea(id));
		return areaMap;
	}

}
