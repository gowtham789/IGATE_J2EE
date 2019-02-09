package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		/*
		 * CREATE TABLE ORDERS
		 * (orderID NUMBER(3),
		 * ProdName VARCHAR2(10),
		 * Quantity NUMBER(2),
		 * orderDATE DATE)
		 */
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
		int count=st.executeUpdate("INSERT INTO Orders VALUES(103,'Mobile',5,sysdate+5)");
		 if(count==1)
		 {
			 System.out.println("Inserted Successfully...");
		 }
		
		int count2=st.executeUpdate("INSERT INTO Orders VALUES(104,'Garments',3,sysdate-2)");
		 if(count2==1)
		 {
			 System.out.println("Inserted Successfully...");
		 }
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}

}
