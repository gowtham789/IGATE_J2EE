package com.igate.munipal.dao;

import com.igate.munipal.dto.FirmMaster;
import com.igate.munipal.exception.FirmException;

public interface RegisterDAO {
	public int InsertData(FirmMaster firm) throws FirmException;

	public int activateData(FirmMaster master) throws FirmException;
}
