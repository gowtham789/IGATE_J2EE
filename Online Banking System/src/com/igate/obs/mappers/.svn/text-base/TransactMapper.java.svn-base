package com.igate.obs.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.obs.dto.TransactionDTO;

public class TransactMapper implements RowMapper 
{

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException 
	{
		TransactionDTO tdto=new TransactionDTO();
		tdto.setTransactionId(rs.getInt(1));
		tdto.setTransDesc(rs.getString(2));
		tdto.setDate(rs.getDate(3));
		tdto.setTransType(rs.getString(4));
		tdto.setTransAmt(rs.getDouble(5));
		tdto.setAccountId(rs.getLong(6));
		return tdto;
	}

}
