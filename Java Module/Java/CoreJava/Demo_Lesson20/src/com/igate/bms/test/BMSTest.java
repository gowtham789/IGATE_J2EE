package com.igate.bms.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.igate.bms.dao.BookDao;
import com.igate.bms.dto.BookDTO;
import com.igate.bms.exception.BookException;

public class BMSTest {

	BookDao bdo=null;
	BookDTO b1=null;
	
	@Before
	public void init()
	{
		bdo=new BookDao();
		b1=new BookDTO(899,"JQuery","Joseph",899);
	}
	

	@After
	public void cleanup()
	{
		bdo=null;
		b1=null;
	}
	@Test
	public void TestInsert()throws BookException
	{
		assertEquals(bdo.insertBook(b1),1007);
	}
	
	@Test
	public void TestBook()throws BookException
	{
		assertTrue(bdo.isBook(1003));
		assertTrue(bdo.isBook(1006));
	}
	
	@Test
	public void TestAllBooks()throws BookException
	{
		assertTrue(bdo.getAllBooks().size()>0);
	}
}
