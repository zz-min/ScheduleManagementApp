<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Studio Login</title>
<script type="text/javascript">
	function login() {
		var loginForm = document.loginForm;

		loginForm.submit();
	}
</script>
</head>
<body>
	<form name="loginForm" action="/studio/login?action=loging"
		method="post">
		<fieldset class="login_fieldset">
			<legend>로그인</legend>
			<div>
				<input type="radio" name="selectlogin" value="admin" required>관리자
				<input type="radio" name="selectlogin" value="rofessor">교직원 <input
					type="radio" name="selectlogin" value="student">학생<br>
			</div>
			<div class="login_property">
				직번(학번) : <input type="text" name="userid" required />
			</div>
			<div class="login_property">
				비밀번호 : <input type="password" name="password" required />
			</div>
			<!-- <input type="hidden" name="loginType" value="admin"> -->
			<input type="button" onclick="login()" value="로그인">
			<div>
				<a href="">아이디 찾기(학번, 직번)</a> <a href="">비밀번호 찾기</a>
			</div>
		</fieldset>
	</form>
</body>
</html>