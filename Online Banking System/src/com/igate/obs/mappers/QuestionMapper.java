package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.UserDTO;

public class QuestionMapper implements  RowMapper 
{

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException 
	{
		UserDTO udto=new UserDTO();
		udto.setSecretQuest(rs.getString(1));
		return udto;
	}

}
