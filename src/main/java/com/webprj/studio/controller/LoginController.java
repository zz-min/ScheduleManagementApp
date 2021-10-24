package com.webprj.studio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.Controller;
import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Student;
import com.webprj.di.entity.Studio;
import com.webprj.studio.service.StudioService;

public class LoginController implements Controller {
	
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		
		String viewName = null;
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST

		int inputID = Integer.parseInt(request.getParameter("userId"));
		String inputPWD = request.getParameter("userPwd");
		String selectLoginType = request.getParameter("selectLoginType");
		
		boolean loginCheck = studioService.getLoginFT(inputID,inputPWD,selectLoginType);//로그인 유효성 검사
		
		
		if (loginCheck == false) {
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
			
			
			List<String> studioLocList=studioService.getStudiosLocList();
			
			request.setAttribute("name", loginName);
			request.setAttribute("id", inputID);
			request.setAttribute("loginType", selectLoginType);
			request.setAttribute("studioLocList", studioLocList);
			
			viewName = "calendar(test).jsp"; 
			//viewName = "calendar(jsp+js).jsp"; 
		}		
		
		return viewName;
	}

}
