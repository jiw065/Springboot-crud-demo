package com.springboot.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.dao.AreaDao;
import com.springboot.demo.entity.Area;
import com.springboot.demo.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	AreaDao areaDao;
	
	@Override
	public List<Area> getAreas() {
		return areaDao.getAreas();
	}

	@Override
	public Area getAreaById(int AreaId) {
		return areaDao.getAreaById(AreaId);
	}

	@Override
	// DDL needs transactional, transactional is default to rollback when runtime exeception throws
	@Transactional
	public boolean addArea(Area a) {	
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		if (a.getAreaName()!=null && !a.getAreaName().equals("")) {
			a.setCreateTime(cal.getTime());
			a.setEditTime(cal.getTime());
			try {
				int effectedNum = areaDao.addArea(a);
				if (effectedNum > 0) {
					return true;
				}else {
					throw new RuntimeException("Failed to add new Area "+a.getAreaName()+" !");
				}
			}catch(Exception e) {
				throw new RuntimeException("Failed to add new Area "+a.getAreaName()+" !"+e.getMessage());
			}
		}else {
			throw new RuntimeException("The Area name cannot to be null!");
		}
	}

	@Override
	@Transactional
	public boolean deleteArea(int AreaId) {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		if (AreaId>0) {
			try {
				int effectedNum = areaDao.deleteArea(AreaId);
				if (effectedNum > 0) {
					return true;
				}else {
					throw new RuntimeException("Failed to delete Area "+AreaId+" !" );
				}
			}catch(Exception e) {
				throw new RuntimeException("Failed to delete Area "+AreaId+" ! " +e.getMessage());
			}
		}else {
			throw new RuntimeException("The Area id cannot to be less than 0!");
		}
	}

	@Override
	@Transactional
	public boolean updateArea(Area a) {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        if (a.getAreaName()!=null && !a.getAreaName().equals("")) {
			try {
				int effectedNum = areaDao.updateArea(a);
				a.setEditTime(cal.getTime());
				if (effectedNum > 0) {
					return true;
				}else {
					throw new RuntimeException("Failed to update Area "+a.getAreaName()+" !" );
				}
			}catch(Exception e) {
				throw new RuntimeException("Failed to update Area "+a.getAreaName()+" !" +e.getMessage());
			}
		}else {
			throw new RuntimeException("The Area name cannot to be null");
		}
	}

}
