package com.cg.mps.test;



import java.sql.Date;

import com.cg.mps.dao.MobileDao;
import com.cg.mps.dto.MobileDTO;


import com.cg.mps.dto.PurchaseDTO;
import com.cg.mps.exception.MobileException;




import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MpsTest {
	MobileDao mdo=null;
	MobileDTO md=null;
	PurchaseDTO pd=null;
	@Before
	public void init()
	{
		mdo=new MobileDao();
		md=new MobileDTO(1003,"Gowtham",20000,"40");
		Date d =new Date(2016,03,16);
		pd=new PurchaseDTO(2008,"Gowtham","gow@gmail.com","9001562525",1003,d);
	}
	@After
	public void cleanup()
	{
		mdo=null;
		md=null;
		pd=null;
	}
	@Test
	public void TestInsert()throws MobileException
	{
		assertTrue(mdo.insertCustdetails(pd)>0);
	}
	
	@Test
	public void TestAllMobiles() throws MobileException
	{
		assertTrue(mdo.getAllDetails().size()>0);
	}
	@Test
	public void TestMobile() throws MobileException
	{
		assertTrue(mdo.isMobile(1003));
	
	}
	@Test
	public void TestDelete() throws MobileException
	{
		assertTrue(mdo.deleteMobile(1004)>0);
	
	}
	@Test
	public void TestRange() throws MobileException
	{
		assertTrue(mdo.getMobileByRange(1000,35000).size()>0);
	
	}
	
	@Test
	public void TestUpdate() throws MobileException
	{
		assertTrue(mdo.updateMobile()>0);
	
	}

	

}
