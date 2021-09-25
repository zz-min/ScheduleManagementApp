<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	integrity="sha384-v8BU367qNbs/aIZIxuivaU55N5GPF89WBerHoGA4QTcbUjYiLQtKdrfXnqAcXyTv"
	crossorigin="anonymous"><!-- Icon사용 URL -->
	
<link
href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700'
rel='stylesheet' type='text/css'><!--font-family: 'Roboto' 기본Font사용 URL -->

<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>스튜디오 예약하기</h2><br><hr>
	<form action="" method="post">
	<div>
		<p>※ 예약중</p>
		<!-- 여기서는 예로 국제관 사법관 얘약 현황에 대해서 DB에서 값을 읽어와서 처리결과를 보여주도록 할것... -->
		<p> <br></p>
		<p> </p>
	</div>
	<div>
		<p>※예약하기</p>
		
		<select>
			<option>건물</option>
			<option>국제관</option>
			<option>사범관</option>
		</select>
		
		<select>
			<option>스튜디오</option>
			<option>202호</option>
			<option>502호</option>
		</select>
	</div>
	
	<div>
		<input type="button" onclick="" value="돌아가기"><input type="submit" value="예약하기" />
	</div>
	</form>
</body>
</html>