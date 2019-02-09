package com.cg.reg.service;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public interface IRegisterService {
	
	String insertRegister(RegisterDto rdto) throws RegisterException;

}
