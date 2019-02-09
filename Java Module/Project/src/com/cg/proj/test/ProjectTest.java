package com.cg.proj.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.proj.beam.ProjectDto;
import com.cg.proj.dao.ProjectDao;
import com.cg.proj.exception.ProjectException;

public class ProjectTest {
	
	ProjectDto pdto=null;
	ProjectDao pdao=null;
	
	@Before
	public void init()
	{
		Date d1=new Date(2016,3,15);
		pdto=new ProjectDto(1012,"Library",5,50,d1);
		pdao=new ProjectDao();
				                 
	}

	@After
	public void cleanup()
	{
		pdto=null;
		pdao=null;
	}
	@Test
	public void TestInsert()throws ProjectException
	{
	
		//for sequence
		assertTrue(pdao.insertProject(pdto)>0);
		//for normal insertion
		//assertEquals(pdao.insertProject(pdto),1025);
	}
	@Test
	public void TestAllProjects()throws ProjectException
	{
		assertTrue(pdao.viewAllProject().size()>0);
	}
	@Test
	public void TestisMobile()throws ProjectException
	{
		assertTrue(pdao.isProject(1008));
	}
	@Test
	public void TestViewProj()throws ProjectException
	{
		Assert.assertEquals(pdao.viewById(1008).getProjectCode(),1008);
	}
	@Test
	public void TestDeleteProj()throws ProjectException
	{
		assertTrue(pdao.deleteProject(1026));
	}
	
}
