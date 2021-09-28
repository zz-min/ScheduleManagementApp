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
	crossorigin="anonymous">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
	rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->

<link href="/css/calendar.css" rel="stylesheet" type="text/css">
<link href="/css/reset.css" rel="stylesheet" type="text/css">

<script src="/js/calendar.js"></script>

<style type="text/css">
/*----------------- reset.css---------------------------- */
body {
	margin: 0;
	padding: 0;
	font-family: 'Roboto', sans-serif;
	font-weight: 500;
}

li,ul {
	list-style: none;/* 땡땡이 점 없애기 */
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;/* 밑줄없애기 */
	color: inherit;/* 파란글씨없애기 */
}

table {
	border-collapse: collapse;
}

h1, h2, h3, h4, h5, h6, div, p, dl, dt, dd, ol, form, fieldset,
	blockquote, address, table, thead, tbody, tfoot, tr, td, caption {
	margin: 0;
	padding: 0;
}
/*----------------- main.css---------------------------- */
header {
    height: 45px;
}

#sectionContainer {
    min-width: 1485px;
    display: block;
    position: relative;
}

/* HEADER */
.calendar_title {
    display: inline-block;
    width: 260px;
    text-align: center;
    font-size: 30px;
    font-weight: 600;
    margin-top: 5px;
}
.calendar_title_logo {
    vertical-align: middle;
    font-size: 30px;    
}
.calendar_title_monthly {
    display: inline-block;
    width: 400px;
    vertical-align: super;
}
.current-year-month {
    font-size: 26px;
    font-weight: 550;
    vertical-align: sub;
}
#icon_calendar {
    color: gray;
    vertical-align: middle;
}
#prev, #next {
    font-size: 20px;
}
/* LEFT */
.leftSection {
    width: 15%;
    min-width: 215px;
    height: 100%;
    float: left;
    position: relative;
    box-sizing: border-box;
}
.userProfile {
    width: 215px;
}
#icon_user {
    color: rgb(51, 51, 51);
    margin: 5%;
}
.profileName {
    display: inline-block;
    vertical-align: super; /* inline 요소 수평정렬 */
    margin-top: 20%;
    font-size: 33px;
}
.rsvBtn {
    font-size: 15px;
    font-weight: 600;
    padding-top: 6px;
    padding-bottom: 6px;
    padding-left: 40px;
    padding-right: 40px;
    margin: 20px auto;
    display: block;
}
.studioContainer{
    margin-top: 50px;
}
.studioLocContainer{
    margin-left: 10px;
    margin-bottom: 20px;
    
}
.studioLocContainer >h1{
    
}
/* RIGHT */
.rightSection {
    width: 85%;
    min-width: 1200px;
    height: 100%;
    position: relative;
    background-color: #F8FAFF;
    float: right;
    box-sizing: border-box;
}
#calendar {
    height: 750px;
    box-sizing: border-box;
    padding: 0.5%;
}
#calendar>div {
    display: block;
    width: 100%
}
.dayHeaderContainer {
    width: 100%;
    height: 35px;
    margin-bottom: 12px;
    display: block;
}
.calendarWeekContainer {
    width: 100%;
    height: calc(100%/ 6.3);
    display: block;
}
.dayHeader {
    height: 100%;
    width: calc(100%/ 7.3);
    display: inline-block;
    padding-top: 8px;
    text-align: center;
    font-size: 20px;
    font-weight: 550;
    background-color: #7C7877;
}
.dayHeader_Sun {
    height: 100%;
    width: calc(100%/ 7.3);
    display: inline-block;
    padding-top: 8px;
    text-align: center;
    font-size: 20px;
    font-weight: 550;
    background-color: #7C7877;
    color: red;
}
.dayHeader_Sat {
    height: 100%;
    width: calc(100%/ 7.3);
    display: inline-block;
    padding-top: 8px;
    text-align: center;
    font-size: 20px;
    font-weight: 550;
    background-color: #7C7877;
    color: blue;
}
.calendar__day {
    height: 97%;
    width: calc(100%/ 7.3);
    display: inline-block;
    margin-right: 5.5px;
    margin-bottom: 2px;
}
.calendar__day>span {
    display: block;
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
		<div class="calendar_title">
			<input type="button" value="week"
				onclick="location.href='/studio/week'" />
		</div>
	</header>

	<div id="sectionContainer">
		<!------------- LEFT --------------->
		<section class="leftSection">
			<div class="userProfile">
				<i class="far fa-user-circle fa-3x" id="icon_user"></i>
				<h2 class="profileName">${name}님</h3>

				<input type="button" value="내 예약현황" class="rsvBtn" onclick="location.href='/studio/reservation'" />
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
