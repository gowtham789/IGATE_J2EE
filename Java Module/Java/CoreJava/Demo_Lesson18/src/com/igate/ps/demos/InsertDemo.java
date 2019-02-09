package com.igate.ps.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.igate.dto.Order;

public class InsertDemo {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
		//Register the Driver	
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	
		//Connection to the DB
            conn = 
				DriverManager.getConnection (
				"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401", "training401");

		Order o1=new Order();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the order Id");
		o1.setOrderId(sc.nextInt());
		
		System.out.println("Enter the product");
		o1.setProductName(sc.next());
		
		System.out.println("Enter the quantity");
		o1.setQuantity(sc.nextInt());
		
		//Insert o1 into Database
		
		ps=conn.prepareStatement("INSERT INTO orders VALUES(?,?,?,sysdate-2)");
		ps.setInt(1, o1.getOrderId());
		ps.setString(2,o1.getProductName());
		ps.setInt(3, o1.getQuantity());
		
		int count = ps.executeUpdate();
		System.out.println(count+" row(s) inserted ");
		
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
