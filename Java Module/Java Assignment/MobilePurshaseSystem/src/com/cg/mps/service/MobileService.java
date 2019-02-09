package com.cg.mps.service;

import java.util.ArrayList;

import com.cg.mps.dao.MobileDao;
import com.cg.mps.dto.MobileDTO;
import com.cg.mps.dto.PurchaseDTO;
import com.cg.mps.exception.MobileException;


public class MobileService implements IMobileService
{
	MobileDao mdao=new MobileDao();
	@Override
	public int insertCustdetails(PurchaseDTO p) throws MobileException {
		int pid=mdao.insertCustdetails(p);
		return pid;
	
	}

	@Override
	public int updateMobile() throws MobileException {
		
		int k= mdao.updateMobile();
		return k;
		
	}

	@Override
	public ArrayList<MobileDTO> getAllDetails() throws MobileException {
		return mdao.getAllDetails();
	}

	@Override
	public int deleteMobile(int id) throws MobileException {
		
		int d=mdao.deleteMobile(id);
		return d;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMobile(int id) throws MobileException 
	{
		
		return mdao.isMobile(id);
	}

	@Override
	public ArrayList<MobileDTO> getMobileByRange(int min, int max)
			throws MobileException {
		
		 return mdao.getMobileByRange(min, max);
	}
	
	
}
