package com.igate.ps.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.igate.dto.Order;

public class SelectOneProduct {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
	//Connection to the DB
		 conn = 
				DriverManager.getConnection (
				"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401", "training401");

		//Create a Statement
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the order to display");
		 int pid=sc.nextInt();
		 
		 ps=conn.prepareStatement("SELECT "
		 		+ "orderId,prodName,quantity "
		 		+ "FROM orders WHERE orderId=?");
		 
		 ps.setInt(1, pid);
		 
		 ResultSet rs=ps.executeQuery();
		
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
				ps.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
