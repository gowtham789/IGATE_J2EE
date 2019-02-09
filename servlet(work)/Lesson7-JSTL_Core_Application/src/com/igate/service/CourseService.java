package com.igate.service;

import java.util.ArrayList;

import com.igate.dao.CourseDao;
import com.igate.dto.Course;


public class CourseService {
	
	private CourseDao eDao;
	
	public CourseService()
	{
		eDao=new CourseDao();
	}
	
	public boolean addcourse(Course course)
	{
		return eDao.addCourse(course);
	}
	
	public ArrayList<Course> retrieveAllcourse()
	{
		return eDao.retrieveAllCourse() ;
	}
	
	public Course retrieveCourse(int eid)
	{
		return eDao.retrieveCourse(eid);
	}
	
	
}
