package com.webprj.studio.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webprj.Control.Controller;
import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Reservation;
import com.webprj.studio.service.StudioService;

public class DataController implements Controller {

	@Override
	public String[] handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService,
			int year, int month,int week) {
		// TODO Auto-generated method stub
		
		String year1=request.getParameter("year");
		String month1=request.getParameter("month");
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(year1);
		System.out.println(month1);
		String sql="TO_CHAR(rsvdate, 'YYYYMM')='"+year+month+"'";
		System.out.println(sql);
		
		List<Reservation> rsvList = studioService.getReservationList(null);
		
		request.setAttribute("testyear",year);
		
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		// TODO Auto-generated method stub
		return null;
	}

}
