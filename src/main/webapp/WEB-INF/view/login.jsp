<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/login.css" />
<title>Studio Login</title>

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
	rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->
	
<link href="/css/login.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="formContainer">
		<form name="loginForm" action="studio/login" method="post">
			<fieldset class="login_fieldset">
				<legend>로그인</legend>
				<div class="login-Type">
					<input type="radio" name="selectLoginType" value="admin" required>관리자
					<input type="radio" name="selectLoginType" value="professor">교직원
					<input type="radio" name="selectLoginType" value="student">학생<br>
					<br>
				</div>
				<div class="login_property">
					<div id="loginPropertyLeft" style="display: inline-block">
						직번(학번) : <input type="text" name="userId" required /> <br><br>
						비밀번호 : <input type="password" name="password" required />
					</div>
					<div id="loginPropertyRight" style="display: inline-block">
						<input type="submit" class="login_button" value="로그인" />
					</div>
				</div>
				<div class="login_find">
					<a href="">아이디 찾기(학번, 직번)</a>&nbsp;&nbsp; <a href="">비밀번호 찾기</a>
				</div>
			</fieldset>
		</form>
	</div>
	<h2>교직원 id : 600548 / pwd : 1234 / 이름 홍길동</h2>
	<h2>학생 id : 201795032 / pwd : 1234 /</h2>
</body>
</html>