package com.igate.service;

import com.igate.dao.LoginDao;


public class LoginService implements ILoginService{

	LoginDao d=new LoginDao();
	@Override
	public boolean isValid(String uname, String pwd) {
		return d.isValid(uname, pwd);
	}

}
