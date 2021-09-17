/*const years = String(date.getFullYear());
const month = String(date.getMonth());*/

//padStart함수 : 글자수 지정후 비어있는 앞자리에 특정문구로 채우는 함수(String에만 적용)
//padEnd함수 : 글자수 지정후 비어있는 뒤자리에 특정문구로 채우는 함수(String에만 적용)

window.onload = function() {

	let today = new Date();
	let firstDate;//이번 달의 첫 날
	let lastDay;//이번 달의 마지막 날
	let prevLastDay;//지난 달의 마지막 날

	const headerYear = document.querySelector('.current-year-month');
	const calendarBody = document.querySelector('.calendar-body');
	const prevEl = document.querySelector('.prev');
	const nextEl = document.querySelector('.next');
	const main = document.querySelector('.main');

	const monthList = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
	const leapYear = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];//윤년
	const notLeapYear = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	let pageYear;

	buildCalendar();

	function buildCalendar() {
		firstDate = new Date(today.getFullYear(), today.getMonth(), 1, today.getDay());//2021.9.1.2(수)
		lastDay = new Date(firstDate.getFullYear(), firstDate.getMonth() + 1, 0).getDate();//9/30 3(목)
		prevLastDay = new Date(firstDate.getFullYear(), firstDate.getMonth(), 0).getDate();//8/31 1(화)
		alert("dd");
		// 윤년 : 4년에 한번씩 2월에 29일인 윤일이 생김
		if (firstDate.getFullYear() % 4 === 0) {
			pageYear = leapYear;//윤년
		} else {
			pageYear = notLeapYear;
		}
		headerYear.innerHTML = `${today.getFullYear()}년&nbsp;&nbsp;&nbsp;&nbsp;${monthList[firstDate.getMonth()]}`;

		makeElement(firstDate);
/*		showMain();
		currentDateget();
		resetInsert();*/
	}


	function makeElement(firstDate) {
		//firstDate :: Wed Sep 01 2021 00:00:00 GMT+0900 (한국 표준시)
		//getMonth() :: 1월 0 ~ 12월 11
		//getDay() :: 월0 ~일6

		//매월 일수가 달라지므로 이번 달 날짜 개수를 세기 위한 변수를 만들고 초기화 합니다.
		let startDayCount = 1;
		let lastDayCount = 1;

		//const setDate = new Date(year, month - 1, 1);
		//const firstDay = firstDate.getDate();
		const firstDayName = firstDate.getDay() - 1;//첫주 시작 월요일로 잡음
		const year = firstDate.getFullYear();
		const month = firstDate.getMonth() + 1;
		//alert(year+"년"+month+"월 1일의 요일은"+(firstDayName+1));
		let calHtml = "";

		for (let i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복        
			for (let j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
				// <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때
				if (i == 0 && j < firstDayName) {
					calHtml += `<div style='background-color:#FFB3BB;' class='calendar__day verticalGutter'><span>${(prevLastDay - (firstDayName - 1) + j)}</span><span></span></div>`;
				}

				// <<1주차>> j == firstDayName: 이번 달 시작 요일일 때
				else if (i == 0 && j == firstDayName) {

					calHtml += `<div style='background-color:#BBFFC9;' class='calendar__day verticalGutter'><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}

				//<<1주차>> j > firstDayName: 이번 달 시작 요일 이후 일 때
				else if (i == 0 && j > firstDayName) {
					calHtml += `<div style='background-color:#BBFFC9' class='calendar__day verticalGutter '><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}

				// startDayCount <= lastDay: 이번 달의 마지막 날이거나 이전일 때
				else if (i > 0 && startDayCount <= lastDay) {
					calHtml += `<div style='background-color:#BBFFC9' class='calendar__day verticalGutter' ><span>${startDayCount}</span><span id='${year}${month}${String(startDayCount++).padStart(2, "0")}'></span></div>`;
				}

				// startDayCount > lastDay: 이번 달의 마지막 날 이후일 때
				else if (startDayCount > lastDay) {
					calHtml += `<div style='background-color:#B9E1FF' class='calendar__day verticalGutter' ><span>${lastDayCount++}</span><span></span></div>`;
				}
			}

		}
		//캘린더 div 태그에 내용 붙임
		main.insertAdjacentHTML("beforeend", calHtml);
	}



	/*
	// 현재 내가 선택한 날짜가 있으면 이전 달, 다음 달로 넘어가도 화면에 보여주기 위해 써줌
	let clickedDate = document.getElementsByClassName(today.getDate());
	clickedDate[0].classList.add('active');


	function removeCalendar() {
		let divEls = document.querySelectorAll('.calendar-body > #weekly > div');
		for (let i = 0; i < divEls.length; i++) {
			divEls[i].remove();
		}
	}

	prevEl.addEventListener('click', function() {
		today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
		removeCalendar();
		buildCalendar();
		resetInsert();
		redrawLi()
	});
	nextEl.addEventListener('click', function() {
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		removeCalendar();
		buildCalendar();
		resetInsert();
		redrawLi()
	});

	function currentDateget() {
		// format()을 이용해서 현재 날짜를 보기좋게 출력해주기 위해 사용.
		currentDate = today.format();
	}*/
}

