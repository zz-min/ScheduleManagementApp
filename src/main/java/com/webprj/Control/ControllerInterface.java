package com.webprj.Control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerInterface {
	String handleRequest(HttpServletRequest request, HttpServletResponse response, SmpService smpService);
}
