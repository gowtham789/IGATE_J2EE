package com.igate.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.bean.Course;


@Repository("userDao")
public class CourseDAOImpl  extends JdbcDaoSupport implements CourseDAOIntf
{
	@Autowired
	private DataSource myDataSource;
	
	@PostConstruct
	private void initialize() {
	setDataSource(myDataSource);
	}

	@Override
	public Course getCourse(int courseId) {
		
		String sql = "SELECT courseid,coursename,duration FROM course WHERE courseId=?";
		Course c= (Course) getJdbcTemplate().queryForObject(sql,new CourseRowMapper(),courseId);
		return c;
	}

	@Override
	public List<Course> getAllCourses() 
	{
		List<Course> courses=getJdbcTemplate().query("select * from course", new CourseRowMapper());
		return courses;
	}

	@Override
	public int addCourse(Course c) {
		
		 String sql="INSERT INTO course VALUES(?,?,?)";   
			Object[] params=new Object[]{c.getCourseId(),c.getCourseName(),c.getDuration()};
			return getJdbcTemplate().update(sql, params);
	}

	@Override
	public int removeCourse(int courseId) {
		String sql="DELETE FROM course WHERE courseId=?";   
		Object[] params=new Object[]{courseId};
		return getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateCourse(Course c) {
		String sql="UPDATE course SET coursename=?,duration=? WHERE courseid=?";   
		Object[] params=new Object[]{c.getCourseName(),c.getDuration(),c.getCourseId()};
		return getJdbcTemplate().update(sql, params);
	}

}
