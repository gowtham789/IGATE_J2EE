package com.cg.em.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.em.beans.EventDTO;

public class EventMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		EventDTO t=new EventDTO();
		t.setEventId(rs.getInt(1));
		t.setEventname(rs.getString(2));
		t.setLocation(rs.getString(3));
		t.setEventType(rs.getString(4));
		
		return t;
	}

	
}
