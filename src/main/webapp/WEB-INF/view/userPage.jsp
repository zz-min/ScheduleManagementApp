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
<title>내 예약현황 페이지</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<%-- <p1>${name}님의 예약현황</p1> --%>
	
	<div class="rsvList">
				<table border="1">
					<th colspan="2">스튜디오</th>
					<th>예약 날짜</th>
					<th>시작 시간</th>
					<th>끝 시간</th>
					<c:forEach var="rsv" items="${rsvList}">
						<tr>
							<td>${rsv.getStudioloc() }</td>
							<td>${rsv.getStudiono() }호</td>
							<td>${rsv.getRsvDate()}</td>
							<td>${rsv.getStartTime()}</td>
							<td>${rsv.getEndTime()}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
</body>
</html>