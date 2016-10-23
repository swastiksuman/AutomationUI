package com.automationui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.automationui.beans.Driver;

@Component("driverDao")
public class DriverDao {
private NamedParameterJdbcTemplate jdbc;
	
	public void DriverDAO(){
		System.out.println("Successfully Loaded DAO");
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Driver> getDrivers() {

		return jdbc.query("select * from driversheet", new RowMapper<Driver>() {

			public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
				Driver driver= new Driver();
				driver.setTc_id(rs.getInt("TC_ID"));
				driver.setExecute(rs.getInt("EXECUTE"));
				driver.setTc_name(rs.getString("TC_NAME"));
				return driver;
			}

		});
	}
	
	public List<Driver> getDrivers(int tc_id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("tc_id", tc_id);
		return jdbc.query("select * from driversheet where tc_id=:tc_id", params, new RowMapper<Driver>() {

			public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
				Driver driver= new Driver();
				driver.setTc_id(rs.getInt("TC_ID"));
				driver.setExecute(rs.getInt("EXECUTE"));
				driver.setTc_name(rs.getString("TC_NAME"));
				return driver;
			}

		});
	}
}
