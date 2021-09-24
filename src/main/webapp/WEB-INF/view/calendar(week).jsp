<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title>
<!-- JSP + JavaScript -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">

<link href="/css/calendar.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<script>
	let day = new Date();
	day.setDate(day.getDate() - day.getDay());

	function week_calandar(week) {
		day.setDate(day.getDate() + week * 7);
		let dayOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
		let title = day.getFullYear() + "/" + (day.getMonth() + 1);
		let data = ""
		
		for (let i = 0; i < 7; i++) {
			if (day.getDate() == new Date().getDate() && day.getMonth() == new Date().getMonth()) data = dayOfWeek[i] + "(toDay)";
			else data = dayOfWeek[i] + "(" + day.getDate() + ")";
			
			if (day.getDate() == 1)
				title += " ~ " + day.getFullYear() + "/"
						+ (day.getMonth() + 1);
			
			day.setDate(day.getDate() + 1);
			
			document.getElementById("dayoftheweek" + i).innerHTML = data;
		}
		day.setDate(day.getDate() - 7);
		
		document.getElementById("year_month").innerHTML = title;
	}

	function set_day() {
		day = new Date();
		day.setDate(day.getDate() - day.getDay());
		
		week_calandar(0);
	}
</script>
<style>
.dayofweek {
	height: 100%;
	width: calc(100%/ 7.3);
	display: inline-block;
	padding-top: 8px;
	text-align: center;
}
</style>
</head>
<body onload=set_day()>
	<!-- onload는 body 태그 실행 후 바로 실행한 스크립트 지정 명령 -->

	<!--------------- HEADER --------------->
	<header>
		<div class="calendar_title">
			<i class="far fa-calendar-check" id="icon_calendar"></i> <span
				class="calendar_title_logo">캘린더</span>
		</div>
		<div class="calendar_title_monthly">
			<button id="prev" onclick=" week_calandar(-1)">&#60;</button>
			<span id="year_month" class="current-year-month"></span>
			<button id="next" onclick="week_calandar(1)">&#62;</button>
			<button id="today" onclick="set_day()">toDay</button>
		</div>
		<div class="calendar_title">
			<input type="button" value="month" onclick="location.href='/studio/month'" />
		</div>
	</header>

	<div id="sectionContainer">
		<!------------- LEFT --------------->
		<section class="leftSection">
			<div class="userProfile">
				<i class="far fa-user-circle fa-3x" id="icon_user"></i>
				<h2 class="profileName">${name}님</h3>

					<button class="rsvBtn">내 예약현황</button>
			</div>


			<div class="studioContainer">
				<c:forEach var="i" begin="0" end="${fn:length(studioLoc)-1}">
					<div class="studioLocContainer">

						<h1>${studioLoc[i]}</h1>
						<c:forEach var="j" items="${studios}">
							<c:if test="${j.getLoc() == studioLoc[i] }">
								<input type="checkbox" name="selectStudio" value="admin"
									required>${j.getStudiono()}
								
							</c:if>
						</c:forEach>
					</div>
				</c:forEach>

			</div>
		</section>


		<!--------------- RIGHT  --------------->
		<section class="rightSection">
			<div id="calendar">
				<div class="dayHeaderContainer">
					<div class="dayHeader_Sun" id="dayoftheweek0"></div>
					<div class="dayHeader" id="dayoftheweek1"></div>
					<div class="dayHeader" id="dayoftheweek2"></div>
					<div class="dayHeader" id="dayoftheweek3"></div>
					<div class="dayHeader" id="dayoftheweek4"></div>
					<div class="dayHeader" id="dayoftheweek5"></div>
					<div class="dayHeader_Sat" id="dayoftheweek6"></div>
				</div>
				<div id="calendar_value">
					<%
					for (int i = 9; i < 23; i++) {
					%>
					<%
					for (int j = 0; j < 7; j++) {
					%>
					<div id="dayofweek<%=i%>" class="dayofweek">
						<% for (int k = 0; k < 60; k = k + 10) {%>
							<div id="weektime<%=k%>" class="weektime"><%=i%>시 <%=k%>분</div>
						<% } %>
					</div>
					<%
					}
					%>
					<%
					}
					%>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
