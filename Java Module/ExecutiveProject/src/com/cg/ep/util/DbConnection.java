package com.cg.ep.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



import oracle.jdbc.pool.OracleDataSource;
/************************************************************************************
 * File                 : 	DbConnection.java
 * Author Name          : 	IGATE
 * Description          : 	Database Connection establishment logic implemented here
 * Creation Date   		: 	09/05/2015
 ************************************************************************************/

public class DbConnection {
	public static Connection getConnection() 
	{
		Connection conn=null;
		try {
			Properties p=new Properties();
			p.load(new FileInputStream("resources/jdbc.properties"));
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			String driver=p.getProperty("driver");
			Class.forName(driver);
			conn=DriverManager.getConnection
				(url,username,password);
			
		} catch (ClassNotFoundException|SQLException|IOException e) {
			System.out.println(e.getMessage());
		} 
		
		return conn;
	}
}
