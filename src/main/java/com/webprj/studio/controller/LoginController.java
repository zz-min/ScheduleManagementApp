package com.webprj.studio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;

import com.webprj.Control.Controller;
import com.webprj.di.entity.*;
import com.webprj.studio.service.StudioService;

public class LoginController implements Controller {
	
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		HttpSession session = request.getSession(true);// 세션이 존재하면 세션반환, 없으면 새로운 세션 생성
		
		String viewName = null;
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST

		int inputID = Integer.parseInt(request.getParameter("userId"));
		String inputPWD = request.getParameter("password");
		String selectLoginType = request.getParameter("selectLoginType");
		
		boolean loginCheck = studioService.getLoginFT(inputID,inputPWD,selectLoginType);//로그인 유효성 검사
		
		
		if (loginCheck == false) {
			session = null;
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script>alert('해당 사용자 정보를 찾을 수 없습니다!'); location.href='/index';</script>");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (loginCheck == true){
			
			String loginName=null;
			if (selectLoginType.equals("manager")) {
				Manager loginObj=studioService.getManager(inputID);
				loginName=loginObj.getManname();
			}else if (selectLoginType.equals("professor")) {
				Professor loginObj=studioService.getProfessor(inputID);
				loginName=loginObj.getProfname();
			}else if (selectLoginType.equals("student")) {
				Student loginObj=studioService.getStudent(inputID);
				loginName=loginObj.getStudentname();
			}
			
			List<Studio> studioList = studioService.getStudioList(null);
			List<String> studioLocList=studioService.getStudiosLocList();
			
			request.setAttribute("name", loginName);
			request.setAttribute("studioList", studioList);
			request.setAttribute("studioLocList", studioLocList);
			/*
			//  세션 구현부
			session.setAttribute("id", inputID);
			session.setAttribute("name", loginName);
			session.setAttribute("loginType", selectLoginType);
			session.setAttribute("studioList", studioList);
			session.setAttribute("studioLocList", studioLocList);
			*/
			viewName = "calendar(test).jsp"; 
			//viewName = "calendar(jsp+js).jsp"; 
		}		
		
		return viewName;
	}

}
