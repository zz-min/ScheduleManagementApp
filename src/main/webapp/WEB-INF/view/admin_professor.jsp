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
<style type="text/css">
table {
	border-collapse: collapse;
}
</style>
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
		<%-- <form name="inquiryForm" action="/studio/professor/re" method="post"
			class="calendar_title_monthly">
			<div>
				<input type="hidden" id="year_form" name="year_form" value="">
				<input type="hidden" id="month_form" name="month_form" value="">
				<input type="button" id="prev" onclick="setMinusMonth()" value="<">
				<span class="current-year-month" id="year-month"></span>
				<input type="button" id="next" onclick="setPlusMonth()" value=">">
				<input type="submit" value="조회">
			</div>
		</form> --%>
	</header>

	<div id="sectionContainer">
		<!------------- LEFT --------------->
		<section class="leftSection">

			<div class="studentList" id="allstud">
				<h1>학생 관리</h1>
				<button id="st_view" onclick="st_view()">예약한 사람만 보기</button>
				<table border="1">
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<c:forEach var="stud" items="${studentAllList}">
						<tr>
							<td>${stud.getStudentno() }</td>
							<td>${stud.getStudentname() }</td>
							<td>${stud.getMajorno() }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="studentList" id="rsvliststud">
				<h1>학생 관리</h1>
				<button id="st_view" onclick="st_view()">전체보기</button>
				<table border="1">
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<c:forEach var="stud" items="${studentAllList}">
						<tr>
							<td>${stud.getStudentno() }</td>
							<td>${stud.getStudentname() }</td>
							<td>${stud.getMajorno() }</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div class="professorList" id="allpro">
				<h1>교수 관리</h1>
				<button id="pro_view" onclick="pro_view()">예약한 사람만 보기</button>
				<table border="1">
					<th>직번</th>
					<th>이름</th>
					<th>학과</th>
					<c:forEach var="prof" items="${professorAllList}">
						<tr>
							<td>${prof.getProfno() }</td>
							<td>${prof.getProfname() }</td>
							<td>${prof.getMajorno() }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="professorList" id="rsvprolist">
				<h1>교수 관리</h1>
				<button id="pro_view" onclick="pro_view()">전체 보기</button>
				<table border="1">
					<th>직번</th>
					<th>이름</th>
					<th>학과</th>
					<c:forEach var="prof" items="${professorAllList}">
						<tr>
							<td>${prof.getProfno() }</td>
							<td>${prof.getProfname() }</td>
							<td>${prof.getMajorno() }</td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</section>

		<!--------------- RIGHT  --------------->
		<section class="rightSection">
			<div class="rsvList">

			</div>
		</section>
	</div>

</body>
</html>