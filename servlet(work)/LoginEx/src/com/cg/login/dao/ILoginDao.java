package com.cg.login.dao;

import com.cg.login.exception.LoginException;

public interface ILoginDao {
	
	boolean isLogin(String username,String Password) throws LoginException;

}
