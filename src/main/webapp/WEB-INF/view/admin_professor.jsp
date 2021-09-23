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
<title>adminPage</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">

<link href="/css/calendar.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

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
	</header>

	<div id="sectionContainer">
		<!------------- LEFT --------------->
		<section class="leftSection">

			<div class="studentList"></div>

			<div class="professorList">
				<h1>교수 관리</h1>
				<table border="1">
					<th>직번</th>
					<th>이름</th>
					<th>학과</th>
					<c:forEach var="prof" items="${professors}">
						<tr>
							<td>${prof.getProfno() }</td>
							<td>${prof.getName() }</td>
							<td>${prof.getDeptno() }</td>
						</tr>
					</c:forEach>
				</table>


			</div>

		</section>

		<!--------------- RIGHT  --------------->
		<section class="rightSection">
			<div class="rsvList"></div>
		</section>
	</div>

</body>
</html>