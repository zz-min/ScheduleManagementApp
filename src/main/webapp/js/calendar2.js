alert(1411);


const D = document.querySelector('.rightSection');

function buildCalendar() {
	alert(27);
	const EEE = document.querySelector('.ad');
	EEE.innerHTML = `안뇽`;
}

$(window).load(function() {//모든 페이지 구성요소 페인팅 완료 후 호출 ONLY ONE
	initJS();
	function initJS() {
		const D = document.querySelector('.rightSection');

		D.insertAdjacentHTML("beforeend", "추가입니다");
		alert("onload");
		buildCalendar();
	}
});

$(document).ready(function() {//DOM Tree 생성 완료 후 호출 (즉, 먼저 실행, 순차적실행)
	alert("aaa");
	const D = document.querySelector('.rightSection');
	
	initJS();
	function initJS() {
		fetchPage('../js/month.txt');
		buildCalendar();
	}	
	function fetchPage(filepath) {
		fetch(filepath).then(function(response) {
			response.text().then(function(text) {
				document.querySelector('.rightSection').innerHTML = text;
			})
		})
	};
});