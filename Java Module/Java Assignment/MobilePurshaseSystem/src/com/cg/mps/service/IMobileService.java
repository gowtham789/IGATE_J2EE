package com.cg.mps.service;

import java.util.ArrayList;

import com.cg.mps.dto.MobileDTO;
import com.cg.mps.dto.PurchaseDTO;
import com.cg.mps.exception.MobileException;


public interface IMobileService
{
	int insertCustdetails(PurchaseDTO p) throws MobileException;
	int updateMobile() throws MobileException;
	ArrayList<MobileDTO> getAllDetails()throws MobileException;
	int deleteMobile(int id) throws MobileException;
	boolean isMobile(int id) throws MobileException;
	ArrayList<MobileDTO> getMobileByRange(int min,int max) throws MobileException;
}
