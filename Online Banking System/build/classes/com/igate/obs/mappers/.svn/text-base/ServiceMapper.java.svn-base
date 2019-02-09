package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.ServiceTrackerDTO;

public class ServiceMapper implements RowMapper 
{

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException
	{
		ServiceTrackerDTO sdto=new ServiceTrackerDTO();
		sdto.setServiceId(rs.getInt(1));
		sdto.setServiceDesc(rs.getString(2));
		sdto.setAccountId(rs.getLong(3));
		sdto.setServiceRaisedDate(rs.getDate(4));
		sdto.setServiceStatus(rs.getString(5));
		return sdto;
	}

}
