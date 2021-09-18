<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page
	import="java.util.Calendar,
	java.util.Date,
	java.util.GregorianCalendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title><!-- JSP + JavaScript -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">

<link href="/css/style.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<script src="/js/calendar.js"></script>

</head>
<body>
	<header>
		<h1 class="calendar_title">
			<i class="far fa-calendar-check" id="apple"></i> <span>캘린더Test</span>
		</h1>
		<div class="calendar_title">
				<button id="prev">&#60;</button>
				<span class="current-year-month"> </span>
				<button id="next">&#62;</button>
			</div>
	</header>
	<div id="a">
		<section class="leftSection">

			<h3>직번(학번) : ${id}</h3>
			<h3>이름 : ${name}</h3>
			<h3>학과코드 : ${deptno}</h3>

		</section>

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
