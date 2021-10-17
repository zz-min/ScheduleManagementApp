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
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		// TODO Auto-generated method stub
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		System.out.println(year);
		System.out.println(month);
		String sql="TO_CHAR(rsvdate, 'YYYYMM')='"+year+month+"'";
		List<Reservation> rsvList=studioService.getReservationList(null);
		
		return "test";
	}

}
