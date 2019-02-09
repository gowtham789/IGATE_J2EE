package com.igate.statement.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.igate.dto.Order;

public class SelectIntoList {

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
		
		ResultSet rs=st.executeQuery("SELECT orderId,prodName,quantity FROM orders");
		
		ArrayList<Order> orderList=new ArrayList<Order>();
		
		while(rs.next())
		{
			//Create an object for every row
			Order temp=new Order();
			
			//Store the values from table into the object
			temp.setOrderId(rs.getInt(1));
			temp.setProductName(rs.getString(2));
			temp.setQuantity(rs.getInt(3));
			
			//Add the object to the list
			orderList.add(temp);
			
		}
		
		System.out.println("------------------------");
		System.out.println("OrderID  Name  Quantity");
		System.out.println("------------------------");
		for(Order e:orderList)
		{
			System.out.println(e.getOrderId()+"  "+e.getProductName()+" "+e.getQuantity());
		}
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}

}
