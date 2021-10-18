package com.webprj.Control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.studio.service.StudioService;

public interface Controller {

	String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService);
	String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService,
			String year, String month,int week);
}