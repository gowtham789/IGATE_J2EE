package com.igate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ReadDateFromJDBC {
	public static void main(String[] args) {
		Connection con=null;
		
		try
		{
		// Register the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Loading Driver Success");

		// Get the connection
		
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401",
				"training401");
		System.out.println("Connection Success");
		
		//Create Oracle Prepared statement	
		PreparedStatement ps=con.prepareStatement(
				"select * from PassPortDetails");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Passport p=new Passport();
			p.setPassportNumber(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setValidFrom(rs.getDate(3));
			System.out.println(p);
		}
		
		
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
			//Throw User defined exception here
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			//Throw User defined exception here
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException se)
			{
				System.out.println(se.getMessage());
				//Throw User defined exception here
			}
		}
	}
}
