package com.webprj.Control;

import java.util.HashMap;
import java.util.Map;

import com.webprj.controller.apiBtnController;
import com.webprj.controller.apiContentController;
import com.webprj.controller.apiScheduleController;
import com.webprj.controller.apiUserController;
import com.webprj.studio.controller.AdminController;
import com.webprj.studio.controller.DataController;
import com.webprj.studio.controller.IndexController;
import com.webprj.studio.controller.LoginController;
import com.webprj.studio.controller.ReservationController;

public class HandlerMapping {
	//private Map<String, Controller> handlerMapper = null;
	private Map<String, Controller> handlerMapper = null;

	public HandlerMapping() {
		handlerMapper = new HashMap<String, Controller>();

		handlerMapper.put("/index", new IndexController());
		handlerMapper.put("/studio/main", new LoginController());
		handlerMapper.put("/studio/admin", new AdminController());
		handlerMapper.put("/studio/reservation", new ReservationController());
		handlerMapper.put("/studio/data", new DataController());

		handlerMapper.put("/api/users", new apiUserController());
		handlerMapper.put("/api/schedule", new apiScheduleController());
		handlerMapper.put("/api/content", new apiContentController());
		handlerMapper.put("/api/btn", new apiBtnController());

	}

	public Controller getHandler(String path) {
		return handlerMapper.get(path);
	}
}
