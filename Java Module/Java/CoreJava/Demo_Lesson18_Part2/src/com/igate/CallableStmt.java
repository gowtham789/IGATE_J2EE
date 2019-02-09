package com.igate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/*
 * CREATE OR REPLACE PROCEDURE remove_dept (dept_no NUMBER) AS
   BEGIN
      DELETE FROM dept
      WHERE dept.dno= dept_no;
   END;
/

*/
public class CallableStmt
    {
     public static void main(String args[])
         {
         try
             {
        	 DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
 			Connection conn = 
 			DriverManager.getConnection (
 					"jdbc:oracle:thin:@172.28.40.3:1521:orcl","trg401","training401");
 		
 			CallableStatement cs2 = conn.prepareCall("{call remove_dept(?)}");
            //cs2.registerOutParameter(1,java.sql.Types.INTEGER);
            cs2.setInt(1,101);
            cs2.execute();
             
         } catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
 		
 	}
}