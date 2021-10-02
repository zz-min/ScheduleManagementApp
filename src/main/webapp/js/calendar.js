//padStart함수 : 글자수 지정후 비어있는 앞자리에 특정문구로 채우는 함수(String에만 적용)
//padEnd함수 : 글자수 지정후 비어있는 뒤자리에 특정문구로 채우는 함수(String에만 적용)

window.onload = function() {
	let today = new Date();
	let firstDate;//이번 달의 첫 날
	let lastDay;//이번 달의 마지막 날
	let prevLastDay;//지난 달의 마지막 날

	const headerYear = document.querySelector('.current-year-month');
	const calendarBody = document.querySelector('#calendar');
	var prevEl = document.getElementById('prev');
	var nextEl = document.getElementById('next');
	
	prevEl.addEventListener("click", prev_week_calandar);
	nextEl.addEventListener("click", next_week_calandar);
	
/*	prevEl.addEventListener("click", prevElClickMonth);
	nextEl.addEventListener("click", nextElClickMonth);*/
	
	
	week_calandar(0);
	//buildCalendar();

	function buildCalendar() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		
		headerYear.innerHTML = `&nbsp;${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${firstDate.getMonth()+1}월&nbsp;`;

		makeElement(firstDate);
	}


	function makeElement(firstDate) {
		//getMonth() :: 1월 0 ~ 12월 11
		//getDay() :: 월0 ~일6

		let startDayCount = 1;
		let lastDayCount = 1;

		const firstDayName = firstDate.getDay() - 1;//첫주 시작 월요일로 잡음
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		const year = firstDate.getFullYear();
		const month = firstDate.getMonth() + 1;
		
		let calHtml = "";

		for (let i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복        
			for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
				// <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때

				if (j ==  0) { calHtml += "<div class='calendarWeekContainer'>" }

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
				if (j == 6) { calHtml += "</div>" }
			}
		}
		//캘린더 div 태그에 내용 붙임
		calendarBody.insertAdjacentHTML("beforeend", calHtml);
	}

	function removeCalendar() {
		let divEls1 = document.querySelectorAll('.calendar__day');
		let divEls2 = document.querySelectorAll('.calendarWeekContainer');
		for (let i = 0; i < divEls1.length; i++) {
			divEls1[i].remove();
		}
		for (let i = 0; i < divEls2.length; i++) {
			divEls2[i].remove();
		}
	}

	function prevElClickMonth() {
		today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
		removeCalendar();
		buildCalendar();
	}
	function nextElClickMonth() {
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		removeCalendar();
		buildCalendar();
	}
	
	function week_calandar(week) {
		today.setDate(today.getDate() + week * 7);		
			
		let title = today.getFullYear() + "/" + (today.getMonth() + 1);
		let data = ""
		
		for (let i = 0; i < 7; i++) {
			if (today.getDate() == new Date().getDate() && today.getMonth() == new Date().getMonth()) data = "< toDay >";
			else data = "(" + today.getDate() + ")";
			
			if (today.getDate() == 1)
				title += " ~ " + today.getFullYear() + "/"
						+ (today.getMonth() + 1);
			
			today.setDate(today.getDate() + 1);
			
			document.getElementById("dayoftheweek" + i).innerHTML = data;
		}
		today.setDate(today.getDate() - 7);
		
		headerYear.innerHTML = title;
	}
	function prev_week_calandar(){
		week_calandar(-1);
		
	}
	function next_week_calandar(){
		week_calandar(1);
	}


}

