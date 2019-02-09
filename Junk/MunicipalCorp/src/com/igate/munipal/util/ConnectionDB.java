package com.igate.munipal.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionDB {
	static Connection connection = null;

	public static Connection getConnection() {

		try {
			InitialContext initial = new InitialContext();
			DataSource data = (DataSource) initial.lookup("java:/jdbc/testDS");
			connection = data.getConnection();
			System.out.println("Done.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
