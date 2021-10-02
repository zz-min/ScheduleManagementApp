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

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous"><!-- Icon사용 URL -->

<link
href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->

<link href="/css/calendar.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<script src="/js/calendar.js"></script>

</head>
<body >
	<!-- onload는 body 태그 실행 후 바로 실행한 스크립트 지정 명령 -->

	<!--------------- HEADER ⊃  calendar_title,calendar_main-------------->
	<div class="headerContainer">

		<div class="calendar_title">
			<i class="far fa-calendar-check" id="icon_calendar"></i> 
			<span class="calendar_title_logo">캘린더</span>
		</div>

		<div class="calendar_main">
			<!-- week -->
			<div class="calendar_main_left">
				<button id="prev" onclick=" week_calandar(-1)">&#60;</button>
				<span id="year_month" class="current-year-month"></span>
				<button id="next" onclick="week_calandar(1)">&#62;</button>
			</div>
			<!-- month -->
			<!-- 
			<div class="calendar_main_left">
				<button id="prev">&#60;</button>
				<span class="current-year-month"> </span>
				<button id="next">&#62;</button>
			</div>
			-->
			<div class="calendar_main_right">
				<input type="button" value="today" class="headerBtn" id="today" onclick="set_day()'" />
				<input type="button" value="month" class="headerBtn" onclick="location.href='/studio/week'" />
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
				</div>
				<input type="button" value="내 예약현황" class="rsvBtn"
					onclick="location.href='/studio/reservation'" />
			</div>


			<div class="studioContainer">
				<c:forEach var="i" begin="0" end="${fn:length(studioLocList)-1}">
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
				</c:forEach>
			</div>
		</div>

		<!--------------- RIGHT  --------------->
		<div class="rightSection">
			<div class="timeLineContainer">
				<div class="timeLineTitle">TIME</div>
				<c:forEach var="i" begin="9" end="18">
					<!-- 9시~18시 -->
					<div class="timeLineItem">${i}:00~ ${i}:30</div>
					<div class="timeLineItem">${i}:30~ ${i+1}:00</div>
				</c:forEach>
			</div>
			<div class="weekContainer">
				<div id="calendar">
					<div class="dayHeaderContainer">
						<div class="dayHeader">
							<span>월</span><span id="dayoftheweek0"></span>
						</div>
						<div class="dayHeader">
							<span>화</span><span id="dayoftheweek1"></span>
						</div>
						<div class="dayHeader">
							<span>수</span><span id="dayoftheweek2"></span>
						</div>
						<div class="dayHeader">
							<span>목</span><span id="dayoftheweek3"></span>
						</div>
						<div class="dayHeader">
							<span>금</span><span id="dayoftheweek4"></span>
						</div>
						<div class="dayHeader">
							<span>토</span><span id="dayoftheweek5"></span>
						</div>
						<div class="dayHeader">
							<span>일</span><span id="dayoftheweek6"></span>
						</div>
					</div>

					<div id="calendar_value">
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>
