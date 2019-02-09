package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
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
		
		//Execute the query
		int count=st.executeUpdate("UPDATE orders set quantity=quantity+1");
		
		System.out.println(count+" rows updated...");
		}
		
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
}
