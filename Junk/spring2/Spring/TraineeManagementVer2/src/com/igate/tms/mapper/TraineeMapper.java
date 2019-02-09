package com.igate.tms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.tms.dto.Trainee;

public class TraineeMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException
	{
		Trainee tdto=new Trainee();
		tdto.setId(rs.getInt(1));
		tdto.setName(rs.getString(2));
		tdto.setLocation(rs.getString(3));
		tdto.setDomain(rs.getString(4));
		
		return tdto;
	}



}
