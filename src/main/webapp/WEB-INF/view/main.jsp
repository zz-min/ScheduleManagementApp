<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<link href="/css/main.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<i class="fas fa-user-cog fa-3x" id="icon"
			onclick="location.href='/studio'"></i>
	</div>
	<h1 id="title">Schedule Management Platform</h1>

	<br>
	<br>
	<br>
	<div class="btnContainer">
		<input type="button" value="studio" onclick="location.href='/studio'" />
		<input type="button" value="rental" onclick="location.href='/rental'" />
		<input type="button" value="btn3" onclick="location.href='/btn3'" />
		<input type="button" value="btn4" onclick="location.href='/btn4'" />
	</div>
	<br>
	<br>
	<div class="btnContainer">
		<input type="button" value="professor" onclick="location.href='/studio/professor'" />
		<input type="button" value="student" onclick="location.href='/studio/student'" />
		<input type="button" value="manager" onclick="location.href='/studio/manager'" />
		<input type="button" value="department" onclick="location.href='/studio/department'" />
	</div>


	<!-- 돌아가기 버튼구현 <input type="button" value="이전으로 돌아가기" onclick="window.history.go(-1);"/> -->
</body>
</html>