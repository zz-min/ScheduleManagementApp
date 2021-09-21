package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Studio;

public interface StudioDao {

	List<Studio> getStudios(String query);
	int insertStudio(Studio studio);
	int updateStudio(Studio studio);
	int deleteStudio(Studio studio);

}