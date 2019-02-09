package com.igate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionDemo {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement ps = null;
		Savepoint sv=null;
		try {
			// Load the Driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			// Get the connection
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg401",
					"training401");
			conn.setAutoCommit(false);
			// Create select query
			Statement st = conn.createStatement();
			st.executeUpdate("insert into prod values(32,'Pen',22)");
			//sv=conn.setSavepoint("New Insert");
			//int a = 7 / 0;
			st.executeUpdate("insert into prod values(36,'iPAD',12)");

			conn.commit();
		} catch (Exception se) {
			try {
				if (conn != null)
				conn.rollback();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(se.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}

	}
}
