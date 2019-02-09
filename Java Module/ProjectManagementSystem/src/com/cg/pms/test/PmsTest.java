package com.cg.pms.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.pms.dao.ProjectDao;
import com.cg.pms.dto.ProjectDTO;
import com.cg.pms.exception.ProjectException;




public class PmsTest 
{
	ProjectDao pdo=null;
	ProjectDTO pd=null;
	@Before
	public void init()
	{
		pdo=new ProjectDao();
		Date d =new Date(2016,03,16);
		pd=new ProjectDTO(106,"FlightApp",12,89,d);
	}
	@After
	public void cleanup()
	{
		pdo=null;
		pd=null;
	}
	@Test
	public void TestInsert()throws ProjectException
	{
		assertTrue(pdo.insertProject(pd)>0);
	}
	@Test
	public void TestAllProjects() throws ProjectException
	{
		assertTrue(pdo.viewAllProjects().size()>0);
	}
	@Test
	public void TestProject() throws ProjectException
	{
		assertTrue(pdo.isProject(101));
	
	}
	@Test
	public void TestDelete() throws ProjectException
	{
		assertTrue(pdo.deleteProject(122));
	
	}
	@Test
	public void TestViewById() throws ProjectException
	{
		assertNotNull(pdo.viewById(103));
	
	}
	
	

}
