package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.CustomerDTO;



public class CustomerMapper implements RowMapper  
{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		CustomerDTO cdto=new CustomerDTO();
		cdto.setAccountId(rs.getLong(1));
		cdto.setCustName(rs.getString(2));
		cdto.setEmail(rs.getString(3));
		cdto.setAddress(rs.getString(4));
		cdto.setPancard(rs.getString(5));
		cdto.setMobileNumber(rs.getString(6));
		return cdto;
	}

}
