package com.webprj.Control;

import java.util.List;

import com.webprj.di.Content;

public interface SmpService {
	boolean loginAvailability(String id,String pwd);
	
	List<Content> contentList(String query);
	List<String> mainContentList(String query);
	List<String> subContentList(String query);
	
	
}
