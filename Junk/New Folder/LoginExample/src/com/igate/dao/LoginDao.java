package com.igate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao implements ILoginDao {

	@Override
	public boolean isValid(String uname, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try {
	
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			
			//Connection to the DB
		conn = 	DriverManager.getConnection (
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "trg432", "training432");

		ps = conn.prepareStatement("SELECT count(*) FROM login WHERE loginid=? and password=?");
		ps.setString(1,uname);
		ps.setString(2,pwd);

		ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			if (count>0)
				status=true;
			else status=false;
			} catch (SQLException e) {
					
				}
				finally
				{
					try
					{
						conn.close();
						ps.close();
					}
					catch(SQLException se)
					{
						
					}
				}
    return status;
	}
}
