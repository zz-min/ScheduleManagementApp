package com.webprj.studio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webprj.Control.Controller;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Studio;
import com.webprj.studio.service.StudioService;

public class DataController implements Controller {

	//JACKSON 으로 JAVA Object형식 -> JSON형식 변환
	//ObjectMapper mapper = new ObjectMapper();
	// result.json 파일로 저장
	//mapper.writeValue(new File("result.json"), myResultObject);
	
	// byte[] 로 저장
	//byte[] jsonBytes = mapper.writeValueAsBytes(myResultObject);
	
	// string 으로 저장
	//String jsonString = mapper.writeValueAsString(myResultObject);
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		String sql=null;
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String week = request.getParameter("week");
		String loc = request.getParameter("loc");
		String id = request.getParameter("id");
		String loginType = request.getParameter("type");
		
		System.out.println("id : "+id+" // type : "+loginType);
		if(week!=null) {//캘린더 데이터 내용 조회
			if(week.equals("0")) {//한달 내용 전체 조회
				sql = "TO_CHAR(rsvdate, 'YYYYMM')='" + year + month + "'";
				System.out.println("sal문출력 >>"+sql);
				List<Reservation> rsvAllList = studioService.getRsvList(sql);
				try {
					jsonString = mapper.writeValueAsString(rsvAllList);
					System.out.println("DataController 한달내용전체조회>>"+jsonString);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}else {//해당하는 주차 조회 - 전혁담당

				
			}
		}else if(loc!=null){
			sql = "studioloc='"+loc+"'";
			List<Studio> studioList = studioService.getStudioList(sql);
			try {
				jsonString = mapper.writeValueAsString(studioList);
				System.out.println("DataController "+loc+"건물에 해달하는 넘버>>"+jsonString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("id")!=null) {
			if (loginType.equals("manager")) {
				sql = "manno = " + id;
			} else if (loginType.equals("professor")) {
				sql = "profno = " + id;
			} else if (loginType.equals("student")) {
				sql = "studentno = " + id;
			}
			String str=" AND TO_CHAR(rsvdate,'RRRRMM') = '" + year + month + "'";
			sql += str;
			List<Reservation> rsvUserList = studioService.getReservationList(sql);
			try {
				jsonString = mapper.writeValueAsString(rsvUserList);
				System.out.println("DataController "+id+"주인의 rsv 조회>>"+jsonString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		return jsonString;
	}

	@Override
	public String handleRequest() {
		// TODO Auto-generated method stub
		return null;
	}

}
