package com.webprj.studio.controller;

import java.util.HashMap;
import java.util.Map;

import com.webprj.Control.Controller;

public class HandlerMapping {

private Map<String, Controller> handlerMapper = null;
	
	public HandlerMapping() {
		handlerMapper = new HashMap<String, Controller>();
		
		handlerMapper.put("/index", new IndexController());
		handlerMapper.put("/studio/main", new LoginController());
		handlerMapper.put("/studio/admin", new AdminController());
		handlerMapper.put("/studio/reservation", new ReservationController());
		/*
		 * handlerMapper.put("/confirm", new ConfirmController());
		 * handlerMapper.put("/delete", new DeleteController());
		 * handlerMapper.put("/update", new UpdateController());
		 * handlerMapper.put("/update_proc", new UpdateProcController());
		 */
	}
	
	public Controller getHandler(String path) {
		return handlerMapper.get(path);
	}
}
