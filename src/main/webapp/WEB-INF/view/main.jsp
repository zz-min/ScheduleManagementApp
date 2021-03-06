<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
	rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->

<link href="/css/main.css?d=5" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script><!-- Icon사용 URL -->
<script>
	$(function() {
		var userLoginDialog, userLoginForm;
		var adminLoginDialog, adminLoginForm;

		var userLoginField = $([]).add("#userId").add("#userPwd");
		var adminLoginField = $([]).add("#adminId").add("#adminPwd");

		function checkLength(o, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error"); //에러 집어넣기
				return false;
			} else {
				o.removeClass("ui-state-error"); //에러 없애기
				return true;
			}
		}
		userLoginDialog = $("#user-login-dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 450,
			modal : true,
			buttons : {
				"확인" : function() {
					userLoginCheckLength();
				},
				"취소" : function() {
					userLoginDialog.dialog("close");
				}
			},
			close : function() {
				userLoginField.removeClass("ui-state-error");//에러 없애기
			}
		});
		function userLoginCheckLength() {
			var valid = true;
			adminLoginField.removeClass("ui-state-error");

			valid = valid && checkLength($("#userId"), 5, 15);
			valid = valid && checkLength($("#userPwd"), 4, 20);
			if (valid) {//true - 로그인 요청
				userLoginFun();
			} else {//false
				alert("로그인과 비밀번호를 다시 확인해 주세요.");
			}
		}

		function userLoginFun() {
			const userId = btoa($("#userId").val());//base64 인코딩
			const userPwd = btoa($("#userPwd").val());
			
			console.log(userId);
			console.log(userPwd);
			loginFetch("/api/users/"+userId+"/"+userPwd,userId,userPwd);
		}
		
		function loginFetch(url,id,pwd) {//GET메소드
			console.log("loginFetch함수 URL : "+url);
			
			fetch(url)
			  .then(res => res.text())
			  .then(res => {
			   if (res=='true') {
			        console.log("로그인 성공");
			        var index=$("#id_check").text().substr(3);
//			        location.href("/main?btn="+index);
//			        window.location.href("/main");
			        window.location.assign("/main?btn="+index);
			    }else 	{alert("로그인과 비밀번호를 다시 확인해 주세요.");} 
			  });
			
		}		

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
				adminLoginField.removeClass("ui-state-error");
			}
		});

		adminLoginForm = adminLoginDialog.find("form").on("submit",
				function(event) {
					var valid = true;
					adminLoginField.removeClass("ui-state-error");

					valid = valid && checkLength($("#adminId"), 5, 15);
					valid = valid && checkLength($("#adminPwd"), 4, 20);
					if (valid) {
						adminLoginDialog.dialog("close");
					}
					return valid;
				});

		$(".button").on("click", function() {
			var id_check = $(this).attr("id");
			$("#id_check").text(id_check);
			userLoginDialog.dialog("open");
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
		<p id="id_check"></p>
	</div>

	<div class="btnContainer">
		<input type="button" name="studioBtn" value="studio 버튼" class="button" id="btn1"/>
		<input type="button" name="studioBtn" value="rental 버튼" class="button" id="btn2"/>
		<input type="button" name="studioBtn" value="aaa 버튼" class="button" id="btn3"/>
		<input type="button" name="studioBtn" value="bbb 버튼" class="button" id="btn4"/>
		<input type="button" name="studioBtn" value="ccc 버튼" class="button" id="btn5"/>
		<input type="button" name="studioBtn" value="ddd 버튼" class="button" id="btn6"/>
		<input type="button" name="studioBtn" value="eee 버튼" class="button" id="btn7"/>
	</div>	
	
 	<!------------------------- studio button - login dialog ------------------------->
	<div id="user-login-dialog-form" class="dialog" title="로그인-test중">
		<div class="login_property">
			<div id="loginPropertyLeft" style="display: inline-block">
				<div class="inputText">
					<label for="userId" class="idLabel">&nbsp아이디 :&nbsp </label> <input
						type="text" name="userId" id="userId"
						placeholder="학번 또는 직번을 입력하세요."
						class="text ui-widget-content ui-corner-all id" required />
				</div>

				<div class="inputText">
					<label for="userPwd" class="passwordLabel">비밀번호 : &nbsp</label> <input
						type="password" name="userPwd" id="userPwd"
						placeholder="비밀번호를 입력하세요."
						class="text ui-widget-content ui-corner-all password" required />
				</div>
			</div>
		</div>
	</div>

	<!------------------------- admin icon button - login dialog ------------------------->
	<div id="admin-login-dialog-form" class="dialog"  title="관리자 로그인">
		<form action="/studio/admin" name="admin_login" method="post">
			<fieldset>
				<div class="login_property">
					<div id="loginPropertyLeft" style="display: inline-block">
						<div class="inputText">
							<label for="adminId" class="idLabel">&nbsp아이디 :&nbsp </label> 
							<input type="text" name="adminId" id="adminId" placeholder="직번을 입력하세요."
								class="text ui-widget-content ui-corner-all id" required />
						</div>

						<div class="inputText">
							<label for="adminPwd" class="passwordLabel">비밀번호 : &nbsp</label> 
							<input 	type="password" name="adminPwd" id="adminPwd" placeholder="비밀번호를 입력하세요."
								class="text ui-widget-content ui-corner-all password" required />
						</div>

					</div>
					<!-- Allow form submission with keyboard without duplicating the dialog button -->
					<div id="loginPropertyRight" style="display: inline-block">
						<input type="submit" name="admin_login" tabindex="-1" style="position: absolute; top: -1000px" />
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