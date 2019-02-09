package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.PayeeDTO;

public class PayeeMapper implements RowMapper 
{

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException 
	{

		PayeeDTO pdto=new PayeeDTO();
		pdto.setPayeeId(rs.getLong(1));
		return pdto;
	}

}
