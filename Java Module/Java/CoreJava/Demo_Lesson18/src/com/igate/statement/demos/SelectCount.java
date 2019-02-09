package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.igate.dto.Order;

public class SelectCount {
	public static void main(String[] args) {
		try
		{
		//Register the Driver	
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	
		//Connection to the DB
		Connection conn = 
				DriverManager.getConnection (
				"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401", "training401");

		//Create a Statement
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT Count(*) FROM orders");
		
		int counter=0;
		if(rs.next())
		{
			counter=rs.getInt(1);
		}
		System.out.println("Count = "+counter);
	
		
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
}
