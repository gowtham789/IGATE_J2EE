package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.igate.dto.Order;

public class SelectOneProduct {

	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		try
		{
		//Register the Driver	
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	
		//Connection to the DB
		 conn = 
				DriverManager.getConnection (
				"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401", "training401");

		//Create a Statement
		 st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT orderId,prodName,quantity FROM orders WHERE orderId=101");
		
		Order o1=new Order();
		while(rs.next())
		{
			//int oid=rs.getInt("orderId");
			int oid=rs.getInt(1);
			o1.setOrderId(oid);
			
			String name=rs.getString(2);
			o1.setProductName(name);
			
			int qty=rs.getInt(3);
			o1.setQuantity(qty);
			
		}
		
		System.out.println(o1);
		
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try {
				conn.close();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
