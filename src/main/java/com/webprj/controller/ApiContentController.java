package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.ControllerInterface;
import com.webprj.Control.SmpService;

public class ApiContentController implements ControllerInterface{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService) {
		String returnMassage=null;
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		System.out.println("ApiContentController path >>"+path);
		System.out.println(method);
		String str=request.getQueryString();
		String year = request.getParameter("btn");
		
		
		if (temp.length == 3) {// /api/contents
			if (method.equals("GET")) {// contents 전체목록 가져오기

			} else if (method.equals("POST")) {// 새로운 contents정보 생성하기

			}
		}else if(temp.length>3) {// /api/contents/[btn type정보]
			if (method.equals("GET")) {// btn type에 따른 contents목록 선별해서 가져오기
				String btnType=temp[4];
				
			}
		}
		
		return returnMassage;
	}

}
