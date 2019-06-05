package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.entity.Area;

public interface AreaService {
	List<Area> getAreas();

	Area getAreaById(int AreaId);

	boolean addArea(Area a);

	boolean deleteArea(int AreaId);

	boolean updateArea(Area a);

}
