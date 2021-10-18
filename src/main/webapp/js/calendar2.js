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

	function buildRsvHeader() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		$(".current-year-month").html(`&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1 }월&nbsp;(예약)`);
	}
	
	async function fetchPage(url,daySet) {
		console.log("async await 함수");
		try {
			const response = await fetch(url);
			const text = await response.text();
			await $(".rightSection").html(text);
			console.log(response);
		} catch (err) {
			console.log(err);
		}
		var daySet= daySet;
		var cnt=0;
		for (let i = 1; i < 7; i++) {//1~6주차를 위해 6번 반복     
			for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
				$(".week"+i).children(":eq("+j+")").children().first().text(daySet[cnt++]);
				$(".week"+i).children(":eq("+j+")").children().last().text(4);
			}
		}
		console.log("async await 함수마무리");
		console.log(`/studio/data?year=${today.getFullYear()}&month=${String(today.getMonth()).padStart(2,'0')}`);
		fetchData(`/studio/data?year=${today.getFullYear()}&month=${String(today.getMonth()).padStart(2,'0')}`,daySet);
	}
	
	async function fetchData(url,daySet) {
		const response = await fetch(url);
		const json = await response.json();
		console.log(json);
		console.log(" 길이 >>"+json.length);
		for(var i=0;i<json.length;i++){
			console.log(json[i].rsvDate.substring(8,10));//'일'단위만 자름
			var day=json[i].rsvDate.substring(8,10);
			var oneday= new Date(today.getFullYear(), today.getMonth(), day);
			console.log(`알아볼 날짜 : ${oneday}  //  몇째주인지 : ${getWeekOfMonth(oneday)}`);
			$(".week"+getWeekOfMonth(oneday)).children(":eq("+oneday.getDay()+")").children().last()
			.text(`${json[i].studioloc} ${json[i].studiono}호)${json[i].startTime}~${json[i].endTime}`);
		}
	}
	function getWeekOfMonth(date){//월요일을 기준으로 한주의 시작을 잡음 
		var selectedDay=date.getDate();
		var first=new Date(date.getFullYear()+'/'+(date.getMonth()+1)+'/01');
		var monthFirstDateDay=first.getDay()-1;
		return Math.ceil((selectedDay+monthFirstDateDay)/7);
	}
	
	buildMonth();
	function buildMonth() {
		console.log("진입1");
		alert("buildMonth진입/** *//");
		
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		$(".current-year-month").html(`&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1 }월&nbsp;(월)`);
		
		//rightSection칸에 month소스 채우기
		fetchPage('../js/m.txt',makeElementMonth(firstDate));
		//fetchPage2('../js/ajaxTest.txt',makeElementMonth(firstDate));
		console.log("마무리1");
		/////////////////////////////////////////////////////////////////
		//console.log($(".week1").children(":eq(5)").children().first().text());//1주차 토요일에 들어가있는 날짜데이터출력
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
		//console.log(calHtml);
		return calHtml;
	}
	
	function buildWeek(week) {
		console.log("buildWeek진입");
		fetchPage('../js/w.txt', makeElementWeek(0));
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