package com.automationui.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automationui.beans.Driver;
import com.automationui.dao.DriverDao;


@Service("testService")
public class TestService{
	
	@Autowired
	DriverDao driverDao;
	
	public List<Driver> getTests(){
		return driverDao.getDrivers();
	}
	
	public List<Driver> getTests(int TC_ID){
		return driverDao.getDrivers(TC_ID);
	}
}
