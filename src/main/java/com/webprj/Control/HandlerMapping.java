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
		handlerMapper.put("/api/schedules", new apiScheduleController());
		handlerMapper.put("/api/contents", new apiContentController());
		handlerMapper.put("/api/btns", new apiBtnController());

	}

	public Controller getHandler(String path) {
		String[] temp=path.split("/"); // /main/studio라면 [0]='', [1]="main", [2]="studio"가 저장됨
		
		for(int i=0;i<temp.length;i++) {
			System.out.println("path split >>"+i+"번째"+temp[i]);
		}
		if(temp.length>3) {//리소스가 2개 초과면 2개까지 분류만 path로 넘기기
			return handlerMapper.get("/"+temp[1]+"/"+temp[2]);
		}else {
			System.out.println(handlerMapper.get(path).toString());
			return handlerMapper.get(path);
		}

	}
}
