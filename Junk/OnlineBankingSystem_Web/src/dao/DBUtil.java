package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	static Connection con;

	public static Connection getConnection() {
		
			try {
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:/jdbc/javaDS");
				con = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return con;

	}
}
