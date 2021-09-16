<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<button class="mainBtn" value="studio" onclick="location.href='views/login.jsp'">studio11</button>
	
	<button class="mainBtn" value="studio" onclick="location.href='studio'">studio22</button>
	<!-- /WEB-INF/view/login.jsp-->
	<button class="mainBtn" value="rental"	onclick="location.href='/rental'">rental</button>
	<button class="mainBtn" value="btn3" onclick="location.href='/btn3'">btn3</button>
	<button class="mainBtn" value="btn4" onclick="location.href='/btn4'">btn4</button>
	<input type="button" value="btn5_input_btn"	onclick="location.href='${pageContext.request.contextPath}/vocaTest/updateForm'" />
	<a href=""/>
	
	<!-- 돌아가기 버튼구현 <input type="button" value="이전으로 돌아가기" onclick="window.history.go(-1);"/> -->
</body>
</html>