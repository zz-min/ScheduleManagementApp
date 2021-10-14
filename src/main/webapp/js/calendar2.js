//padStart함수 : 글자수 지정후 비어있는 앞자리에 특정문구로 채우는 함수(String에만 적용)
//padEnd함수 : 글자수 지정후 비어있는 뒤자리에 특정문구로 채우는 함수(String에만 적용)

$(document).ready(function() {//DOM Tree 생성 완료 후 호출 (즉, 먼저 실행, 순차적실행)
	//alert("2)document.ready");
});

$(window).load(function() {//모든 페이지 구성요소 페인팅 완료 후 호출 ONLY ONE
	let today = new Date();
	let firstDate;//이번 달의 첫 날
	let lastDay;//이번 달의 마지막 날
	let prevLastDay;//지난 달의 마지막 날

	$("#prev").click(function(event) {
		if ($(".mwBtn").val() == 'weekly') {
			prevElClickMonth();
		} else if ($(".mwBtn").val() == 'monthly') {
			prevElClickWeek();
		} else if ($(".mwBtn").val() == '예약수정') {
			prevElClickRsv();
		}
	});

	$("#next").click(function(event) {
		if ($(".mwBtn").val() == 'weekly') {
			nextElClickMonth();
		} else if ($(".mwBtn").val() == 'monthly'){
			nextElClickWeek();
		}else if ($(".mwBtn").val() == '예약수정') {
			nextElClickRsv();
		}
	});
	
	$(".mwBtn").click(function(event){
		if ($(".mwBtn").val() == 'weekly') {
			$(".mwBtn").val('monthly');

			buildWeek(0);
		} else {
			$(".mwBtn").val('weekly');

			buildMonth();
		}
	});
	$(".todayBtn").click(function(event) {
		
	});
	$(".rsvBtn").click(function(event) {
		if ($(".rsvBtn").val() == '예약현황') {
			$(".rsvBtn").val("돌아가기");
			$(".mwBtn").val("예약수정");
			$(".todayBtn").val("예약취소");
			buildRsvHeader();
			
			fetchPage2('/studio/reservation');
		} else if ($(".rsvBtn").val() == "돌아가기") {
			$(".rsvBtn").val('예약현황');
			$(".mwBtn").val("weekly");
			$(".todayBtn").val("today");
			buildMonth();
		}
	});
	
	
	/*
	async function fetchPageTest(filepath, str) {///////////////////////////////////////////////////////////////
		console.log("fetch함수");

		let response = await fetch(filepath);
		if (!response.ok) {
			console.log("error");
		}

		console.log("완성");
		console.log($('.a').text());
		console.log($('#20211011').text());
	};*/


	function buildRsvHeader() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		$(".current-year-month").html(`&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1 }월&nbsp;(예약)`);
	}
	
	buildMonth();
	function buildMonth() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		$(".current-year-month").html(`&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1 }월&nbsp;(월)`);
		//rightSection칸에 month소스 채우기
		$(".rightSection").load('../js/m.txt',function(){
			//month틀 로드 후 callback함수정의 ( 내부 데이터 변경 )
			//console.log($("#ff").text());
			//$("#ff").text("9");
			var daySet= makeElementMonth(firstDate);
			var cnt=0;
			for (let i = 1; i < 7; i++) {//1~6주차를 위해 6번 반복     
			   console.log(i+"주차");
				for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
					$(".week"+i).children(":eq("+j+")").children().first().text(daySet[cnt++]);
					console.log(i+"주차"+j+"요일");
				}
			}
		});
		
		/////////////////////////////////////////////////////////////////
	}

	function makeElementMonth(firstDate) {
		//getMonth() :: 1월 0 ~ 12월 11
		//getDay() :: 월0 ~일6
		let startDayCount = 1;
		let lastDayCount = 1;

		const firstDayName = firstDate.getDay() - 1;//첫주 시작 월요일로 잡음
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		const year = firstDate.getFullYear();
		const month = firstDate.getMonth() + 1;
		var calHtml = [];
		var cnt=0;
		for (let i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복        
			for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
				// <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때

				if (i == 0 && j < firstDayName) {
					calHtml[cnt++] = `${(prevLastDay - (firstDayName - 1) + j)}`;
				}
				// <<1주차>> j == firstDayName: 이번 달 시작 요일일 때
				else if (i == 0 && j == firstDayName) {
					calHtml[cnt++] = `${startDayCount++}`;
				}
				//<<1주차>> j > firstDayName: 이번 달 시작 요일 이후 일 때
				else if (i == 0 && j > firstDayName) {
					calHtml[cnt++] = `${startDayCount++}`;
				}
				// startDayCount <= lastDay: 이번 달의 마지막 날이거나 이전일 때
				else if (i > 0 && startDayCount <= lastDay) {
					calHtml[cnt++] = `${startDayCount++}`;
				}
				// startDayCount > lastDay: 이번 달의 마지막 날 이후일 때
				else if (startDayCount > lastDay) {
					calHtml[cnt++] = `${lastDayCount++}`;
				}
			}
		}
				console.log(calHtml);
		return calHtml;
	}
	
	function buildWeek(week) {
		fetchPage('../js/week.txt', makeElementWeek(0));
		today.setDate(today.getDate() + week * 7);
		let title = "&nbsp;" + today.getFullYear() + "년&nbsp;&nbsp;&nbsp;&nbsp;" + (today.getMonth() + 1) + "월&nbsp;(주)";

		for (let i = 0; i < 7; i++) {
			if (today.getDate() == 1)
				title += " ~&nbsp;&nbsp;&nbsp;&nbsp; " + today.getFullYear() + "년&nbsp;&nbsp;&nbsp;&nbsp;"
					+ (today.getMonth() + 1) + "월";

			today.setDate(today.getDate() + 1);
		}
		today.setDate(today.getDate() - 7);

		$(".current-year-month").html(title);
	}

	function makeElementWeek(week){
		var weekDate = new Date(today);
		weekDate.setDate(weekDate.getDate() + week * 7);//나타낼 주 날짜 읽어와서 저장하기 0,-1,+1

		if (weekDate.getDay() == 0) {
			weekDate.setDate(weekDate.getDate() - 6);
		} else {
			weekDate.setDate(weekDate.getDate() - (weekDate.getDay() - 1));
		}//첫주 시작 월요일로 잡기
		
		var data = "";//dayHeaderContainer내부 세팅
		const daySet=["월","화","수","목","금","토","일"];

		for (let i = 0; i < 7; i++) {//0~6
			data += `<div class='dayHeader'><span>${daySet[i]}</span><span>`;

			if (weekDate.getDate() == new Date().getDate() && weekDate.getMonth() == new Date().getMonth()) {
				data += `< toDay >`;
			}
			else {
				data += "(" + weekDate.getDate() + ")";
			}
			data += "</span></div>";
			weekDate.setDate(weekDate.getDate() + 1);
		}
		data += "</div><div id='calendar_value'></div></div></div>";

		return data;
	}

	function removeCalendarMonth() {//Monthly내부에 달력내용만 지우기
		let divEls1 = document.querySelectorAll('.calendar__day');
		let divEls2 = document.querySelectorAll('.calendarWeekContainer');
		for (let i = 0; i < divEls1.length; i++) {
			divEls1[i].remove();
		}
		for (let i = 0; i < divEls2.length; i++) {
			divEls2[i].remove();
		}
	}

	function removeCalendarWeek() {
		$("#calendar").remove();
	}

	function prevElClickMonth() {
		today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
		removeCalendarMonth();
		buildMonth();
	}
	
	function nextElClickMonth() {
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		removeCalendarMonth();
		buildMonth();
	}
	
	function prevElClickWeek() {
		buildWeek(-1);
	}

	function nextElClickWeek() {
		buildWeek(1);
	}
	
	function prevElClickRsv() {
		today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
		removeCalendarMonth();
	}
	
	function nextElClickRsv() {
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		removeCalendarMonth();
	}	
});