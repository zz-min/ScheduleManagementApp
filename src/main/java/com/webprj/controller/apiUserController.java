package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.ControllerInterface;
import com.webprj.Control.SmpService;

public class apiUserController implements ControllerInterface{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService) {
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		System.out.println("apiUserController path >>"+path);
		
		////////삭제될 부분
		int inputID = Integer.parseInt(request.getParameter("userId"));
		String inputPWD = request.getParameter("userPwd");
		String selectLoginType = request.getParameter("selectLoginType");
		
		/////////
		
		if (temp.length == 3) {// /api/users
			if (method == "GET") {// users 전체목록 가져오기

			} else if (method == "POST") {// 새로운 user정보 생성하기

			}
		}if(temp.length>3) {// /api/users/[ID인코딩정보]
			if(method=="GET") {// ID의 정보를 가져오기
				boolean loginCheck = smpService.getLoginFT(inputID,inputPWD,selectLoginType);//로그인 유효성 검사
				
				
			}else if(method=="UPDATE") {// ID의 정보를 수정하기
				
			}else if(method=="DELETE") {// ID의 정보를 삭제하기
				
			}
		}
		
		
		if(method=="GET") {
			
		}else if(method=="POST") {
			
		}else if(method=="UPDATE") {
			
		}else if(method=="DELETE") {
			
		}
		
		
		return null;
	}

}
