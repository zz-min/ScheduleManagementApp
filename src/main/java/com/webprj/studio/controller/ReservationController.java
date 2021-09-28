package com.webprj.studio.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webprj.Control.Controller;
import com.webprj.di.entity.Manager;
import com.webprj.di.entity.Professor;
import com.webprj.di.entity.Reservation;
import com.webprj.di.entity.Student;
import com.webprj.studio.service.StudioService;

public class ReservationController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, StudioService studioService) {
		HttpSession session = request.getSession(true);// 세션이 존재하면 세션반환, 없으면 새로운 세션 생성

		int id=(int) session.getAttribute("id");
		String loginType=(String) session.getAttribute("loginType");
		String str = null;
		
		if (loginType.equals("manager")) {
			str = "manno = " + id;

		} else if (loginType.equals("professor")) {
			str = "profno = " + id;

		} else if (loginType.equals("student")) {
			str = "studentno = " + id;
		}
		 
				
		List<Reservation> rsvList=studioService.getReservationList(str);	
		
		//  세션 구현부
		session.setAttribute("rsvList", rsvList);
		
		return "userPage.jsp";
	}

}
