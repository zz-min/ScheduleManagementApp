package com.webprj.Control;

import java.util.List;

import com.webprj.dao.*;
import com.webprj.di.Content;

public class SmpServiceImpl implements SmpService {
	private LoginDao loginDao = null;
	private ContentDao contentDao = null;
	
	public SmpServiceImpl() {}
	
	public SmpServiceImpl(LoginDao loginDao,ContentDao contentDao) {
		this.loginDao = loginDao;
		this.contentDao = contentDao;
	}


	@Override
	public boolean loginAvailability(String id, String pwd) {
		return loginDao.loginAvailability(id, pwd);
	}

	@Override
	public List<Content> contentList(String query) {
		return contentDao.contentList(query);
	}

	@Override
	public List<String> mainContentList(String query) {
		return contentDao.mainContentList(query);
	}

	@Override
	public List<String> subContentList(String query) {
		return contentDao.subContentList(query);
	}

}
