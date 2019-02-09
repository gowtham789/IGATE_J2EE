package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.bean.Course;
import com.igate.dao.CourseDAOImpl;
import com.igate.dao.CourseDAOIntf;


@Service("courseService")
public class CourseServiceImpl implements CourseServiceIntf {
	
	@Autowired
	CourseDAOIntf userDao;

	@Override
	public Course getCourse(int courseId) {
	
		return userDao.getCourse(courseId);
	}

	@Override
	public List<Course> getAllCourses() 
	{
		return userDao.getAllCourses();
	}

	@Override
	public int addCourse(Course c) {
		
		return userDao.addCourse(c);
	}

	@Override
	public int removeCourse(int courseId) {
		
		return userDao.removeCourse(courseId);
	}

	@Override
	public int updateCourse(Course c) {
		
		return userDao.updateCourse(c);
	}

}
