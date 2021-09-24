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

<script src="/js/calendar.js"></script>

</head>
<body>

	<!--------------- HEADER --------------->
	<header>
		<div class="calendar_title">
			<i class="far fa-calendar-check" id="icon_calendar"></i> <span
				class="calendar_title_logo">캘린더</span>
		</div>
		<div class="calendar_title_monthly">
			<button id="prev">&#60;</button>
			<span class="current-year-month"> </span>
			<button id="next">&#62;</button>
		</div>
		<div class="calendar_title">
			<input type="button" value="week" onclick="location.href='/studio/week'" />
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
								<input type="checkbox" name="selectStudio" value="admin"required>${j.getStudiono()}
								<br>
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
					<div class="dayHeader">월</div>
					<div class="dayHeader">화</div>
					<div class="dayHeader">수</div>
					<div class="dayHeader">목</div>
					<div class="dayHeader">금</div>
					<div class="dayHeader">토</div>
					<div class="dayHeader">일</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
