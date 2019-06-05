package com.springboot.demo.dao;

import java.util.List;

import com.springboot.demo.entity.Area;

public interface AreaDao {

	List<Area> getAreas();

	Area getAreaById(int AreaId);

	int addArea(Area a);

	int deleteArea(int AreaId);

	int updateArea(Area a);

}