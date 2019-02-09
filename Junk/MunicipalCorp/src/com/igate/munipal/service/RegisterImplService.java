package com.igate.munipal.service;

import com.igate.munipal.dao.RegisterDAO;
import com.igate.munipal.dao.RegisterImplDAO;
import com.igate.munipal.dto.FirmMaster;
import com.igate.munipal.exception.FirmException;

public class RegisterImplService implements RegisterService {
	RegisterDAO dao = new RegisterImplDAO();

	@Override
	public int InsertData(FirmMaster firm) throws FirmException {
		// TODO Auto-generated method stub
		return dao.InsertData(firm);
	}

	@Override
	public int activateData(FirmMaster master) throws FirmException {
		// TODO Auto-generated method stub
		return dao.activateData(master);
	}

}
