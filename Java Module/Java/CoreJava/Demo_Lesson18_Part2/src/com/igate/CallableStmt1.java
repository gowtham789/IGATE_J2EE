package com.igate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*CREATE OR REPLACE PROCEDURE spgetDept(
		 deptno IN NUMBER,
		 dname OUT VARCHAR2,
		 loc OUT VARCHAR2)
		 AS
		 BEGIN
		    SELECT dname,loc INTO dname,loc FROM dept WHERE dno=deptno;
		 END;*/
public class CallableStmt1 {

	public static void main(String[] args) {
		 try
         {
    	 DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			Connection conn = 
			DriverManager.getConnection (
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl","trg401","training401");
			
			CallableStatement cs2 = conn.prepareCall("{call spgetDept(?,?,?)}");
			cs2.setInt(1, 103);
			cs2.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs2.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs2.executeUpdate();
			 
			String deptName = cs2.getString(2);
			String location = cs2.getString(3);
			System.out.println(deptName+" "+location);
         } catch (SQLException e) {
  			System.out.println(e.getMessage());
  		}
	}

}
