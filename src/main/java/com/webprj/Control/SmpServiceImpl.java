package com.webprj.Control;

import com.webprj.dao.LoginDao;

public class SmpServiceImpl implements SmpService {
	private LoginDao loginDao = null;

	public SmpServiceImpl(LoginDao loginJdbc) {
		this.loginDao = loginJdbc;

	}
	
	@Override
	public boolean loginAvailability(String id, String pwd) {
		return loginDao.loginAvailability(id, pwd);
	}

}
