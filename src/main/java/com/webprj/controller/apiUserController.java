package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.Controller;
import com.webprj.studio.service.StudioService;

public class apiUserController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		System.out.println("apiUserController path >>"+path);
		String id=request.getParameter("id");
		
		////////삭제될 부분
		int inputID = Integer.parseInt(request.getParameter("userId"));
		String inputPWD = request.getParameter("userPwd");
		String selectLoginType = request.getParameter("selectLoginType");
		/////////
		
		if (temp.length == 2) {// /api/users?id=2020
			if (method == "GET") {
				if (id != null) {// ?id=2020 - id정보 유효성검사
					boolean loginCheck = studioService.getLoginFT(inputID,inputPWD,selectLoginType);//로그인 유효성 검사
					return loginCheck==true?"true" :"false";
				} else {// /api/users - users 전체목록 가져오기
					
				}

			} else if (method == "POST") {// 새로운 user정보 생성하기

			}
		}if(temp.length==2) {// /api/users/[ID정보]
			if(method=="GET") {// ID의 정보를 가져오기
				
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
