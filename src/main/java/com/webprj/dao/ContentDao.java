package com.webprj.dao;

import java.util.List;

import com.webprj.di.Content;

public interface ContentDao {
	List<Content> contentList(String query);
	List<String> mainContentList(String query);
	List<String> subContentList(String query);
}
