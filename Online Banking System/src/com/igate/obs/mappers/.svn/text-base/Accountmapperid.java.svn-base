package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.AccountDTO;


public class Accountmapperid implements RowMapper 
{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException
	{
		AccountDTO adto=new AccountDTO();
		adto.setAccountId(rs.getLong(1));
		return adto;
	}

}
