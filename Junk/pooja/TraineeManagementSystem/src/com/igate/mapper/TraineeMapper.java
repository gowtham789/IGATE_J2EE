package com.igate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.beans.Trainee;

public class TraineeMapper implements RowMapper<Trainee>{

	@Override
	public Trainee mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Trainee traineeDetails=new Trainee();
		traineeDetails.setTraineeId(rs.getInt(1));
		traineeDetails.setTraineeName(rs.getString(2));
		traineeDetails.setTraineeDomain(rs.getString(3));
		traineeDetails.setTraineeLocation(rs.getString(4));
		return traineeDetails;
	}

	
}
