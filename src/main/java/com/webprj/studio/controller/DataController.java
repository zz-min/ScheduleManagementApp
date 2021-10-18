package com.webprj.studio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webprj.Control.Controller;
import com.webprj.di.entity.Reservation;
import com.webprj.studio.service.StudioService;

public class DataController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService,
			String year, String month,int week) {
		// TODO Auto-generated method stub
		System.out.println("DataController 진입1");
		/*
		String year1=request.getParameter("year");
		String month1=request.getParameter("month");*/

		String sql="TO_CHAR(rsvdate, 'YYYYMM')='"+year+month+"'";
		System.out.println("sql 문 >>"+sql);
		
		List<Reservation> rsvList = studioService.getReservationList(sql);
		request.setAttribute("rsvList",rsvList);
		
		ObjectMapper mapper = new ObjectMapper();
		/*JACKSON 으로 JAVA Object형식 -> JSON형식 변환
		// result.json 파일로 저장
		mapper.writeValue(new File("result.json"), myResultObject);
		// byte[] 로 저장
		byte[] jsonBytes = mapper.writeValueAsBytes(myResultObject);
		// string 으로 저장
		String jsonString = mapper.writeValueAsString(myResultObject);
		*/

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(rsvList);
			System.out.println("이거지 JSON");
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		// TODO Auto-generated method stub
		System.out.println("DataController 진입2");
		return null;
	}

}
