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
	crossorigin="anonymous"><!-- Icon사용 URL -->

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
	rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->

<link href="/css/main.css?d=5" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function() {
	var loginDialog, loginForm;
	var adminLoginDialog, adminLoginForm;
	
	var userId = $("#userId"), password = $("#password"), 
	allField = $([]).add(userId).add(password);
	
	function checkLength(o, min, max) {
		console
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			return false;
		} else {
			return true;
		}
	}
	
	loginDialog = $("#login-dialog-form").dialog({
		autoOpen : false,
		height : 400,
		width : 450,
		modal : true,
		buttons : {
			"확인" : function() {
				loginForm.trigger("submit");
			},
			"취소" : function() {
				loginDialog.dialog("close");
			}
		},
		close : function() {
			//			confirmForm[ 0 ].reset();
			allField.removeClass("ui-state-error");
		}
	});
	adminLoginDialog = $("#admin-login-dialog-form").dialog({
		autoOpen : false,
		height : 300,
		width : 450,
		modal : true,
		buttons : {
			"확인" : function() {
				adminLoginForm.trigger("submit");
			},
			"취소" : function() {
				adminLoginDialog.dialog("close");
			}
		},
		close : function() {
			//			confirmForm[ 0 ].reset();
			allField.removeClass("ui-state-error");
		}
	});
	
	adminLoginForm = adminLoginDialog.find("form").on("submit", function(event) {
		var valid = true;
		allField.removeClass("ui-state-error");
		
		valid = valid && checkLength(userId, 5, 15);
		valid = valid && checkLength(password, 4, 20);
		if (valid) {
			adminLoginDialog.dialog("close");
		}
		return valid;
	});
	
	loginForm = loginDialog.find("form").on("submit", function(event) {
		var valid = true;
		allField.removeClass("ui-state-error");
		
		valid = valid && checkLength(userId, 5, 15);
		valid = valid && checkLength(password, 4, 20);
		if (valid) {
			loginDialog.dialog("close");
		}
		return valid;
	});
	$(".button").on("click", function() {
		loginDialog.dialog("open");
	});
	$("#admin-icon").on("click", function() {
		adminLoginDialog.dialog("open");
	});
});
</script>
</head>
<body>
	<div class="iconContainer">
		<i class="fas fa-user-cog fa-3x" id="admin-icon"></i><!-- admin페이지로 이동 -->
	</div>
	
	<div class="titleContainer">
		<h1 id="title">Schedule Management Platform</h1>
	</div>

	<div class="btnContainer">
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="studioBtn"/>
	</div>	


 	<!------------------------- studio button - login dialog ------------------------->
	<div id="login-dialog-form" class="dialog" title="로그인">
		<form action="/studio/main" name="login" method="post">
			<fieldset>
			
				<div class="loginTypeContainer">
					<input type="radio" name="selectLoginType" class="loginType" value="manager" required>관리자&nbsp&nbsp&nbsp
					<input type="radio" name="selectLoginType" class="loginType" value="professor" checked>교직원&nbsp&nbsp&nbsp
					<input type="radio" name="selectLoginType" class="loginType" value="student">학생&nbsp&nbsp&nbsp&nbsp<br>
					<br>
				</div>

				<div class="login_property">

					<div id="loginPropertyLeft" style="display: inline-block">
					
						<div class="inputText">
							<label for="userId" id="userIdLabel">&nbsp아이디 :&nbsp </label> 
							<input type="text" name="userId" id="userId"
								placeholder="학번 또는 직번을 입력하세요."
								class="text ui-widget-content ui-corner-all" required />
						</div>
						
						<div class="inputText">
							<label for="password" id="passwordLabel">비밀번호 : &nbsp</label> 
							<input type="password" name="password" id="password"
								placeholder="비밀번호를 입력하세요."
								class="text ui-widget-content ui-corner-all" required />
						</div>
						
					</div>
					<!-- Allow form submission with keyboard without duplicating the dialog button -->
					<div id="loginPropertyRight" style="display: inline-block">
						<input type="submit" name="login" tabindex="-1"
							style="position: absolute; top: -1000px" />
					</div>
				</div>
				<div class="refContatiner">
					<p>교수 id : 600548 / pwd : 1234 / 이름 홍길동</p>
					<p>학생 id : 201795032 / pwd : 1234 /이름 : 하니</p5>
					<p>관리자 id : 205521 / pwd : 1234 /이름 : 김진짜</p>
				</div>
			</fieldset>
		</form>
		
	</div>
	
	<!------------------------- admin icon button - login dialog ------------------------->
	<div id="admin-login-dialog-form" class="dialog"  title="관리자 로그인">
		<form action="/studio/admin" name="admin_login" method="post">
			<fieldset>
				<div class="login_property">
					<div id="loginPropertyLeft" style="display: inline-block">
						<div class="inputText">
							<label for="userId" id="userIdLabel">&nbsp아이디 :&nbsp </label> <input
								type="text" name="userId" id="userId" placeholder="직번을 입력하세요."
								class="text ui-widget-content ui-corner-all" required />
						</div>

						<div class="inputText">
							<label for="password" id="passwordLabel">비밀번호 : &nbsp</label> <input
								type="password" name="password" id="password"
								placeholder="비밀번호를 입력하세요."
								class="text ui-widget-content ui-corner-all" required />
						</div>

					</div>
					<!-- Allow form submission with keyboard without duplicating the dialog button -->
					<div id="loginPropertyRight" style="display: inline-block">
						<input type="submit" name="admin_login" tabindex="-1"
							style="position: absolute; top: -1000px" />
					</div>
				</div>
				<div class="refContatiner">
					<p>관리자 id : 205521 / pwd : 1234 /이름 : 김진짜</p>
				</div>
			</fieldset>
		</form>
	</div>

	<!-- 돌아가기 버튼구현 <input type="button" value="이전으로 돌아가기" onclick="window.history.go(-1);"/> -->
</body>
</html>