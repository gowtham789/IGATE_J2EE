package com.igate.dao;
/* Table Creation in database
 * CREATE table Course(
 * courseId NUMBER(6) PRIMARY KEY,
 * courseName VARCHAR2(30),
 * courseDuration NUMBER(5)
 * );
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.helpers.Loader;

import com.igate.dto.Course;
public class CourseDao {
	Properties jdbcProperties;
	public  CourseDao()
	{
		FileInputStream fis;
		try {
			URL url=Loader.getResource("oracle.properties"); 
			fis = new FileInputStream(url.getFile());
			jdbcProperties=new Properties();
			jdbcProperties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName(jdbcProperties.getProperty("driver"));
			String url=jdbcProperties.getProperty("url");
			String unm=jdbcProperties.getProperty("user");
			String pwd=jdbcProperties.getProperty("password");
			con=DriverManager.getConnection(url,unm,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public boolean addCourse(Course course)
	{
		Connection con=getConnection();
		int insertSuccess=0;
		String insQry="insert into Course values(?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(insQry);
			pst.setInt(1, course.getCourseId());
			pst.setString(2,course.getCourseName());
			pst.setDouble(3,course.getCourseDuration());
			insertSuccess=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(insertSuccess>0)
			return true;
		else
			return false;
	}


	public ArrayList<Course> retrieveAllCourse()
	{
		ArrayList<Course> cList=new ArrayList<Course>();
		Connection con=getConnection();
		String qry="select courseId,courseName,courseDuration from Course" ;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next())
			{
				Course course=new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setCourseDuration(rs.getInt(3));
				cList.add(course);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cList;
	}


	public Course retrieveCourse(int cid)
	{
		Course course=null;
		System.out.println("In dao "+cid);
		Connection con=getConnection();
		String qry="select courseId ,courseName, courseDuration from Course where courseId=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, cid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				course=new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseDuration(rs.getInt(3));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course;
	}
}
