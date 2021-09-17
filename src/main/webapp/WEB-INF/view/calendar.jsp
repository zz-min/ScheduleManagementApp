<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.Calendar,java.util.Date,java.util.GregorianCalendar"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous">
<link href="/css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="/js/calendar.js"></script>
<script src="/js/calTest.js"></script> -->
</head>
<body>
	<%
	Calendar nowCal = Calendar.getInstance();//현재날짜 2021-09-18-토(7)
	int year = nowCal.get(Calendar.YEAR); // Calendar 인스턴스에 있는 저장된 필드 값을 가져옴 
	int month = nowCal.get(Calendar.MONTH);//월 0~11 (1월~12월)
	int day = nowCal.get(Calendar.DATE);
	int dayOfWeek = nowCal.get(Calendar.DAY_OF_WEEK);//요일 1~7 ()
	int lastDay = nowCal.getActualMaximum(Calendar.DATE); // 해당 월의 마지막 일(date)를 반환

	Calendar firstCal = new GregorianCalendar();//현재 달의 첫번째 날
	firstCal = nowCal;
	firstCal.set(Calendar.DATE, 1);
	int firstDayName = firstCal.get(Calendar.DAY_OF_WEEK);
	Calendar preCal = new GregorianCalendar();
	if (month == 1) {
		preCal.set(Calendar.YEAR, year - 1);
		preCal.set(Calendar.MONTH, 11);//12월
	} else {
		preCal.set(Calendar.YEAR, year);
		preCal.set(Calendar.MONTH, month - 1);
	}
	preCal.set(Calendar.DATE, 1);

	int yearPre = preCal.get(Calendar.YEAR);
	int monthPre = preCal.get(Calendar.MONTH);
	int dayPre = preCal.get(Calendar.DATE);
	int lastDayPre = preCal.getActualMaximum(Calendar.DATE); // 해당 월의 마지막 일(date)를 반환

	String calHtml = new String();
	int startDayCount = 1;
	int lastDayCount = 1;
	%>
	<c:set var="firstDayName" value="<%=firstDayName%>" />
	<c:set var="lastDayPre" value="<%=lastDayPre%>" />
	<h3>직번(학번) : ${id}</h3>
	<h3>이름 : ${name}</h3>
	<h3>학과코드 : ${deptno}</h3>
	<header>
		<h1>
			<i class="far fa-calendar-check"></i> <span>캘린더</span>
		</h1>
		<div class="calendar_title">
			<button class="prev">&#60;</button>
			<span class="current-year-month"> <%=year%>년&nbsp;&nbsp;&nbsp;&nbsp;<%=month%>월
			</span>
			<button class="next">&#62;</button>
		</div>
	</header>
	<div id="calendar">

		<c:forEach var="i" begin="0" end="5">
			<!-- 1~6주차를 위해 6번 반복 -->
			<div>${i}</div>
			<c:forEach var="j" begin="0" end="6">
				<!-- 일요일~토요일을 위해 7번 반복 -->
				<c:if test="${i==0}">악
					<c:if test="${j<(firstDayName -2)}">
						<div>야호</div>
						${lastDayPre}
						<div style='background-color: #FFB3BB;'
							class='calendar__day horizontalGutter verticalGutter'>
							<span>${(lastDayPre - (firstDayName - 3) + j)}</span><span></span>
						</div>
					</c:if>
				</c:if>



			</c:forEach>


		</c:forEach>


	</div>


</body>
</html>