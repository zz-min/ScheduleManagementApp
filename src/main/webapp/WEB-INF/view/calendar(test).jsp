<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더TEST</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
	rel='stylesheet' type='text/css'>
<!--font-family: 'Roboto' 기본Font사용 URL -->

<link href="/css/calendar.css?D" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="/js/calendar2.js"></script>
</head>
<body>
	<!--------------- HEADER ⊃  calendar_title,calendar_main-------------->
	<div class="headerContainer">

		<div class="calendar_title">
			<i class="far fa-calendar-check" id="icon_calendar"></i> <span
				class="calendar_title_logo">캘린더</span>
		</div>

		<div class="calendar_main">

			<div class="calendar_main_left">
				<button id="prev">&#60;</button>
				<span class="current-year-month"> </span>
				<button id="next">&#62;</button>
			</div>

			<div class="calendar_main_right">
				<input type="button" value="weekly" class="mwBtn headerBtn" />
				<!-- toggle -->
				<input type="button" value="today" class="todayBtn headerBtn" />
			</div>

		</div>
	</div>


	<!--------------- SECTION  ⊃  leftSection.studioContainer --------------->
	<div class="sectionContainer">
		<!------------- LEFT --------------->
		<div class="leftSection">
			<div class="userProfile">
				<div class="prifileTitle">
					<i class="far fa-user-circle fa-3x" id="icon_user"></i>
					<h2 class="profileName">${name}님</h2>
					<span id="type">${loginType}</span>
					<span id="id">${id}</span>
				</div>
				<input type="button" value="예약현황" class="rsvBtn"/>
					<!-- onclick="location.href='/studio/reservation'" --> 
			</div>


			<div class="studioContainer">
				<form>
					<select name="checkedLoc1" id="checkedLoc1" class="checkedLoc">
						<option value="none">== 건물 선택 ==</option>
						<c:forEach var="i" begin="0" end="${fn:length(studioLocList)-1}">
							<option value="${studioLocList[i]}">${studioLocList[i]}</option>
						</c:forEach>
					</select>
					<select name="checkedLoc2" id="checkedLoc2" class="checkedLoc">
						<option value="none">== 건물을 먼저 선택해주세요 ==</option>
					</select>
				</form>
				
					<div class="studioLocContainer">

						<h1>${studioLocList[i]}</h1>
						<c:forEach var="j" items="${studioList}">
							<c:if test="${j.getStudioloc() == studioLocList[i] }">
								<input type="checkbox" name="selectStudio" value="admin"
									required>${j.getStudiono()}
								<br>
							</c:if>
						</c:forEach>
					</div>
				
			</div>
		</div>
		<!--------------- RIGHT  --------------->
		<div class="rightSection"></div>
	</div>
</body>
</html>
