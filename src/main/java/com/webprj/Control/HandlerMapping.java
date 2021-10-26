package com.webprj.Control;

import java.util.HashMap;
import java.util.Map;

import com.webprj.controller.ApiBtnController;
import com.webprj.controller.ApiContentController;
import com.webprj.controller.ApiScheduleController;
import com.webprj.controller.ApiUserController;
import com.webprj.controller.MainController;
import com.webprj.studio.controller.IndexController;

public class HandlerMapping {
	private Map<String, ControllerInterface> handlerMapper = null;

	public HandlerMapping() {
		handlerMapper = new HashMap<String, ControllerInterface>();

		handlerMapper.put("/index", new IndexController());
		handlerMapper.put("/main", new MainController());
		
		handlerMapper.put("/api/users", new ApiUserController());
		handlerMapper.put("/api/schedules", new ApiScheduleController());
		handlerMapper.put("/api/contents", new ApiContentController());
		handlerMapper.put("/api/btns", new ApiBtnController());

	}

	public ControllerInterface getHandler(String path) {
		String[] temp=path.split("/"); // /main/studio라면 [0]='', [1]="main", [2]="studio"가 저장됨
		
		if(temp.length>3) {//리소스가 2개 초과면 2개까지 분류만 path로 넘기기
			return handlerMapper.get("/"+temp[1]+"/"+temp[2]);
		}else {
			return handlerMapper.get(path);// /api/users
		}
	}
}
