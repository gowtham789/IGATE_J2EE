package com.trainee.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.trainee.bean.Trainee;

public class TraineeMappers implements RowMapper<Trainee> {

	@Override
	public Trainee mapRow(ResultSet rs, int arg1) throws SQLException
	{
		Trainee tdetails=new Trainee();
		tdetails.setTraineeId(rs.getInt(1));
		tdetails.setTraineeName(rs.getString(2));
		tdetails.setTraineeDomain(rs.getString(3));
		tdetails.setTraineeLocation(rs.getString(4));
		return tdetails;
	}

}
