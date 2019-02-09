package com.igate.munipal.service;

import com.igate.munipal.dto.FirmMaster;
import com.igate.munipal.exception.FirmException;

public interface RegisterService {
	public int InsertData(FirmMaster firm) throws FirmException;

	public int activateData(FirmMaster master) throws FirmException;
}
