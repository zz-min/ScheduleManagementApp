package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Manager;

public interface ManagerDao {//관리자
	Manager getManager(int manno);
	
	List<Manager> getManagerList(String query);

}
