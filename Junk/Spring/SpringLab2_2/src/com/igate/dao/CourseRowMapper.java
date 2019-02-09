package com.igate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.bean.Course;

public class CourseRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Course c=new Course();
		c.setCourseId(rs.getInt(1));
		c.setCourseName(rs.getString(2));
		c.setDuration(rs.getInt(3));
		return c;
	}

}
