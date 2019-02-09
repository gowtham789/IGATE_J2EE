package com.igate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.beans.Domain;

public class DomainMapper implements RowMapper<Domain>{

	@Override
	public Domain mapRow(ResultSet rs, int arg1) throws SQLException {
	
		Domain d=new Domain();
		d.setDomain(rs.getString(1));
		return d;
	}

}
