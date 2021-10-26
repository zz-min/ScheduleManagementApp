package com.webprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.webprj.Control.ControllerInterface;
import com.webprj.Control.SmpService;

public class ApiUserController implements ControllerInterface{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService) {
		String returnMassage=null;
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		System.out.println("apiUserController path >>"+path);
		System.out.println(method);
		Base64 base64 = new Base64();

		/////////
		if (temp.length == 3) {// /api/users
			if (method.equals("GET")) {// users 전체목록 가져오기

			} else if (method.equals("POST")) {// 새로운 user정보 생성하기

			}
		}else if(temp.length>3) {// /api/users/[ID인코딩정보]/[pwd인코딩정보]
			if(method.equals("GET")) {// ID의 정보를 가져오기
				String id=new String(base64.decode(temp[3].getBytes()));//디코딩된값
				String pwd=new String(base64.decode(temp[4].getBytes()));
				
				System.out.println("확인할 정보"+id+ " ////// " + pwd);
				boolean loginCheck = smpService.loginAvailability(id,pwd);//로그인 유효성 검사
				if(loginCheck) {//로그인 유효시
					//JWT토큰 발행 
					
					/*
					//1)header
					JSONObject header= new JSONObject();
					header.put("alg","HS256"); //해쉬알고리즘
					header.put("typ","JWT"); // 토큰타입 - JWT
					
					//2)payload
					JSONObject payload= new JSONObject();
					payload.put("sub","HS256"); //Reserved 주제
					payload.put("name","JWT"); // Public
					payload.put("admin",false); // Private
					
					//3)signature
					String signature=null;
					
					//Base64.encodeBase64(text.getBytes()) -> 인코딩
					//base64.decode(text.getBytes()) -> 디코딩
					 */
					HttpSession session = request.getSession(true);
					session.setAttribute("id", id);
					
					returnMassage= "true";
				}else returnMassage= "false";
				
			}else if(method.equals("UPDATE")) {// ID의 정보를 수정하기
				
			}else if(method.equals("DELETE")) {// ID의 정보를 삭제하기
				
			}
		}
		
		
		/*
		 * if(method.equals("GET")) {
		 * 
		 * }else if(method.equals("POST")) {
		 * 
		 * }else if(method.equals("UPDATE")) {
		 * 
		 * }else if(method.equals("DELETE")) {
		 * 
		 * }
		 */
		
		return returnMassage;
	}

}
