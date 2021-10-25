package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
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
		
		/////////
		if (temp.length == 3) {// /api/users
			if (method == "GET") {// users 전체목록 가져오기

			} else if (method == "POST") {// 새로운 user정보 생성하기

			}
		}if(temp.length>3) {// /api/users/[ID인코딩정보]
			if(method=="GET") {// ID의 정보를 가져오기
				String id=null;//이미 인코딩 되어있음
				String pwd=null;				
				boolean loginCheck = smpService.loginAvailability(id,pwd);//로그인 유효성 검사
				if(loginCheck) {
					//JWT토큰 발행 
					
					//1)header
					JSONObject header= new JSONObject();
					header.put("alg","HS256"); //해쉬알고리즘
					header.put("typ","JWT"); // 토큰타입 - JWT
					
					//1)header
					JSONObject payload= new JSONObject();
					payload.put("sub","HS256"); //Reserved 주제
					payload.put("name","JWT"); // Public
					payload.put("admin",false); // Private
					
					String signature=null;
					//Base64.encodeBase64(text.getBytes()) -> 인코딩
					
					//String token=
				}else return "false";
				
			}else if(method=="UPDATE") {// ID의 정보를 수정하기
				
			}else if(method=="DELETE") {// ID의 정보를 삭제하기
				
			}
		}
		
		
		if(method=="GET") {
			
		}else if(method=="POST") {
			
		}else if(method=="UPDATE") {
			
		}else if(method=="DELETE") {
			
		}
		
		
		return "오류인데요?";
	}

}
