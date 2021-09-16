<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css" />
<title>Studio Login</title>
<style>
.login_button {
	width: 55px;
	height: 60px;
	position: absolute;
	left: 280px;
	top: 80px;
}

.login_fieldset {
	width: 320px;
}

.login_select {
	text-align: center;
}

.login_property {
	width: 250px;
	text-align: right;
}

.login_find {
	text-align: center;
}
</style>
</head>
<body>
	<form name="loginForm" action="/studio/login"
		method="post">
		<fieldset class="login_fieldset">
			<legend>로그인</legend>
			<div class="login_select">
				<input type="radio" name="selectlogin" value="admin" required>관리자
				<input type="radio" name="selectlogin" value="rofessor">교직원
				<input type="radio" name="selectlogin" value="student">학생<br>
				<br>
			</div>
			<div class="login_property">
				직번(학번) : <input type="text" name="userId" required /> <br>
				비밀번호 : <input type="password" name="password" required /> <input
					type="submit" class="login_button" value="로그인" />
			</div>
			<!-- <input type="hidden" name="loginType" value="admin"> -->
			<div class="login_find">
				<br> <a href="">아이디 찾기(학번, 직번)</a> <a href="">비밀번호 찾기</a>
			</div>
		</fieldset>
	</form>
</body>
</html>