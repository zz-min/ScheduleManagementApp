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
		if ($(".mwBtn").val() == 'monthly') {
			prevElClickMonth();
		} else {
			prevElClickWeek();
		}
	});

	$("#next").click(function(event) {
		if ($(".mwBtn").val() == 'monthly') {
			nextElClickMonth();
		} else {
			nextElClickWeek();
		}
	});
	
	$(".mwBtn").click(function(event){
		if ($(".mwBtn").val() == 'monthly') {
			$(".mwBtn").val('weekly');

			buildWeek(0);
		} else {
			$(".mwBtn").val('monthly');

			buildMonth();
		}
	});
	$(".todayBtn").click(function(event){	});
	
	function fetchPage(filepath,str) {
		var textEl="";
		fetch(filepath)
			.then(function(response) {	
				response.text()
			.then(function(text) {
				if(filepath=='../js/m.txt'){
					textEl=text+str+'</div>';
				}else if(filepath=='../js/week.txt'){
					textEl=text;					
				}
				$(".rightSection").html(textEl);
			})
		});
	}

	function buildWeek(week) {
		fetchPage('../js/week.txt',null);
		today.setDate(today.getDate() + week * 7);
		let title = today.getFullYear() + "&nbsp;년&nbsp;&nbsp;&nbsp;&nbsp;" + (today.getMonth() + 1)+"월&nbsp;(주)";
		
		for (let i = 0; i < 7; i++) {
			if (today.getDate() == 1)
				title += " ~&nbsp;&nbsp;&nbsp;&nbsp; " + today.getFullYear() + "년&nbsp;&nbsp;&nbsp;&nbsp;"
					+ (today.getMonth() + 1) +"월";

			today.setDate(today.getDate() + 1);
		}
		today.setDate(today.getDate() - 7);

		$(".current-year-month").html(title);
		
		$(".todayBtn").trigger("click");
		makeElementWeek(0);
	}
	
	function makeElementWeek(week){
		$(`.dayHeaderContainer`).css({
			"background-color":"red"
		});
		$(`.calendar_title_logo`).css({
			"background-color":"red"
		});
		today.setDate(today.getDate() + week * 7);

		var data = "";

		for (let i = 0; i < 7; i++) {
			if (today.getDate() == new Date().getDate() && today.getMonth() == new Date().getMonth()) data = "< toDay >";
			else data = "(" + today.getDate() + ")";

			today.setDate(today.getDate() + 1);

			$(`#dayoftheweek${i}`).html(data);
		}
		today.setDate(today.getDate() - 7);
	}
	
	buildMonth();
	function buildMonth() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		$(".current-year-month").html(`&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1 }월&nbsp;(월)`);
		fetchPage('../js/m.txt',makeElementMonth(firstDate));
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

		var calHtml = "";

		for (let i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복        
			for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
				// <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때

				if (j == 0) { calHtml += "<div class='calendarWeekContainer'>" ;}

				if (i == 0 && j < firstDayName) {
					calHtml += `<div style='background-color:#D9D4CF;' class='calendar__day'><span>${(prevLastDay - (firstDayName - 1) + j)}</span><span></span></div>`;
				}
				// <<1주차>> j == firstDayName: 이번 달 시작 요일일 때
				else if (i == 0 && j == firstDayName) {
					calHtml += `<div style='background-color:#ABD0CE;' class='calendar__day'><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}
				//<<1주차>> j > firstDayName: 이번 달 시작 요일 이후 일 때
				else if (i == 0 && j > firstDayName) {
					calHtml += `<div style='background-color:#ABD0CE' class='calendar__day'><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}
				// startDayCount <= lastDay: 이번 달의 마지막 날이거나 이전일 때
				else if (i > 0 && startDayCount <= lastDay) {
					calHtml += `<div style='background-color:#ABD0CE' class='calendar__day' ><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}
				// startDayCount > lastDay: 이번 달의 마지막 날 이후일 때
				else if (startDayCount > lastDay) {
					calHtml += `<div style='background-color:#D9D4CF' class='calendar__day'><span>${lastDayCount++}</span><span></span></div>`;
				}
				if (j == 6) { calHtml += "</div>" ;}
			}
		}
		return calHtml;
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
		let delSection = document.querySelector("#calendar");
		delSection.remove();
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
});
		/*
		$(".leftSection").text("d");
		$(".rightSection").text("d");
		$(".leftSection").css({
			"background-color":"pink"
		});
		*/
