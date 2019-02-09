package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.igate.util.DbConnection;

public class InsertDemo {

	public static void main(String[] args) {
		
		try
		
		{
		//Connection to the DB
		Connection conn = 
				DbConnection.getConnection();

		//Create a Statement
		Statement st=conn.createStatement();
		
		//Execute the query
		int count=st.executeUpdate("INSERT INTO Orders VALUES(105,'Shoes',3,sysdate+5)");
		 if(count==1)
		 {
			 System.out.println("Inserted Successfully...");
		 }
		
		int count2=st.executeUpdate("INSERT INTO Orders VALUES(106,'Bags',2,sysdate-2)");
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
