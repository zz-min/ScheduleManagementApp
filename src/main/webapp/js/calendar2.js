alert(1);

const a = document.querySelector('.rightSection');

$(document).ready(function() {//DOM Tree 생성 완료 후 호출 (즉, 먼저 실행, 순차적실행)
	alert("2");
	
	const b = document.querySelector('.rightSection');
	
	//initJS();
	
	function initJS() {
		//fetchPage('../js/month.txt');
		//a.insertAdjacentHTML("beforeend", "추가입니다");
		a.innerHTML = "aa";
		b.innerHTML = "bb";
		buildCalendar();
	}	
	
	function fetchPage(filepath) {
		fetch(filepath).then(function(response) {
			response.text().then(function(text) {
				D.innerHTML = text;
			})
		})
	};
	
});

$(window).load(function() {//모든 페이지 구성요소 페인팅 완료 후 호출 ONLY ONE
	initJS();
	function initJS() {
		const c = document.querySelector('.rightSection');
		//D.insertAdjacentHTML("beforeend", "추가입니다");
		//a.innerHTML = "aa";
		c.innerHTML = "bb";
		alert("onload");
		//buildCalendar();
	}
});

function buildCalendar() {
	alert(27);
	const EEE = document.querySelector('.ad');
	EEE.innerHTML = `안뇽`;
}

