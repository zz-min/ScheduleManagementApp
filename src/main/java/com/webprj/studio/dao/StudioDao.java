package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Studio;

public interface StudioDao {

	List<Studio> getStudioList(String query);
	
	List<String> getStudiosLocList();

}