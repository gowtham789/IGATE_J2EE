package com.igate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class InsertDateFromJDBC {
	/*
	 * SQL> CREATE TABLE PassPortDetails  
	  (passportNum NUMBER(6), 
	   name VARCHAR2(10), 
	   validFrom DATE);
	 */

	// Demo to insert DATE from Java to ORACLE table
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
		
		//Insert a Passport Object
		Passport p1=new Passport();
		p1.setPassportNumber(12345);
		p1.setName("Vihar");
		
		System.out.println("Enter Date in mm/dd/yyyy format");
		Scanner sc=new Scanner(System.in);
		Date temp=new Date(sc.next());
		p1.setValidFrom(temp);
		System.out.println(p1);
		
		//Create Oracle Prepared statement
		
		PreparedStatement ps=con.prepareStatement(
				"insert into PassPortDetails values(?,?,?)");
		ps.setInt(1, p1.getPassportNumber());
		ps.setString(2,p1.getName());
		
		//new java.sql.Date(2010,04,24);
		java.sql.Date sDate=
				new java.sql.Date(p1.getValidFrom().getYear(),
						p1.getValidFrom().getMonth(),
						p1.getValidFrom().getDate()); 
		ps.setDate(3,sDate);
		ps.executeUpdate();
		
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
