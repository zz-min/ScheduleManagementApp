package com.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.ControllerInterface;
import com.webprj.Control.SmpService;

public class MainController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService) {
		String viewName=null;
		String path = request.getRequestURI();
		System.out.println("MainController path >>"+path);
		String query=request.getQueryString();
		
		String str="content_type='btn"+query.substring(4)+"'";
		
		List<String> mainContentList = smpService.mainContentList(str);

		request.setAttribute("mainContentList", mainContentList);

		viewName = "calendar(test).jsp";

		return viewName;
	}

}
