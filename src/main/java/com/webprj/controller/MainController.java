package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.ControllerInterface;
import com.webprj.Control.SmpService;

public class MainController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService) {
		String returnMassage=null;
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		System.out.println("MainController path >>"+path);
		System.out.println(request.getMethod());
		System.out.println(method);
		
		if(method.equals("GET")) {
			returnMassage="calendar(test).jsp";  
		}
		
		return returnMassage;
	}

}
