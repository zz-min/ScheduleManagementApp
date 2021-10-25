package com.webprj.Control;

import com.webprj.dao.*;

public class SmpServiceImpl implements SmpService {
	private LoginDao loginDao = null;
	
	public SmpServiceImpl() {}
	
	public SmpServiceImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	@Override
	public boolean loginAvailability(String id, String pwd) {
		return loginDao.loginAvailability(id, pwd);
	}

}
