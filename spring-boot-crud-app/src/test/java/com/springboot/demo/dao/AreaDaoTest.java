package com.springboot.demo.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.entity.Area;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
	@Autowired
	private AreaDao areaDao; 
	
	@Test
	@Ignore
	public void testGetAreas() {
		List<Area> alist = areaDao.getAreas();
		assertEquals("testing injection","North York", alist.get(1).getAreaName());
	}

	@Test
	@Ignore
	public void testGetAreaById() {
		Area a = areaDao.getAreaById(1);
		assertEquals("North York", a.getAreaName());
	}

	@Test
	public void testAddArea() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		Area a = new Area();
		a.setAreaName("Markham");
		a.setCreateTime(cal.getTime());
		a.setEditTime(cal.getTime());
		a.setPriority(3);
		int effectedNum = areaDao.addArea(a);
		assertEquals(1,effectedNum);
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		int id = 4;
		Area a = areaDao.getAreaById(id);
		if (a!=null) {
			int effectedNum = areaDao.deleteArea(id);
			assertEquals(1, effectedNum);
		}else {
			fail("The entity is not existing, please test again");
		}
		
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		Area a = areaDao.getAreaById(3);
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		a.setAreaName("Markham");
		a.setEditTime(cal.getTime());
		int effectedNum = areaDao.updateArea(a);
		assertEquals(1, effectedNum);
		
	}

}
