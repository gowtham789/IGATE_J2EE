package com.igate;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401",
					"training401");
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT dno,loc FROM dept WHERE dno=102");
			while (rs.next()) {

				int no = rs.getInt(1);
				String loc = rs.getString(2);
				System.out.println(no + " " + loc);
			}
			
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			System.out.println(rsmd.getColumnName(1));
			System.out.println(rsmd.getColumnTypeName(1));
			
			DatabaseMetaData dmd=conn.getMetaData();
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getUserName());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
