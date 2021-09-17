package test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class javaTest {

	/*
	 * void setCalendarData(int year,int month) { //빈 문자열을 만들어줍니다. String calHtml;
	 * 
	 * //getMonth(): Get the month as a number (0-11) Date setDate = new Date(year,
	 * month - 1, 1); Date firstDate = new Date(today.getYear(), today.getMonth(),
	 * 1);
	 * 
	 * //getDate(): Get the day as a number (1-31) //이번 달의 첫째 날을 구합니다. Date firstDay
	 * = setDate.getDate();
	 * 
	 * //getDay(): Get the weekday as a number (0-6) //이번 달의 처음 요일을 구합니다. Date
	 * firstDayName = setDate.getDay();
	 * 
	 * //new Date(today.getFullYear(), today.getMonth(), 0); //Date객체의 day 인자에 0을
	 * 넘기면 지난달의 마지막 날이 반환됩니다. //new Date(today.getFullYear(), today.getMonth(), 1);
	 * //Date객체의 day 인자에 1을 넘기면 이번달 첫째 날이 반환됩니다. //이번 달의 마지막 날을 구합니다. const lastDay
	 * = new Date( today.getFullYear(), today.getMonth() + 1, 0 ).getDate(); //지난 달의
	 * 마지막 날을 구합니다. const prevLastDay = new Date( today.getFullYear(),
	 * today.getMonth(), 0 ).getDate();
	 * 
	 * //매월 일수가 달라지므로 이번 달 날짜 개수를 세기 위한 변수를 만들고 초기화 합니다. let startDayCount = 1; let
	 * lastDayCount = 1;
	 * 
	 * 
	 * for (let i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복 for (let j = 0; j < 7; j++)
	 * {//일요일~토요일을 위해 7번 반복 // <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때 if (i ==
	 * 0 && j < firstDayName - 1) { calHtml += `<div
	 * style='background-color:#FFB3BB;' class='calendar__day horizontalGutter
	 * verticalGutter'><span>${(prevLastDay - (firstDayName - 2) +
	 * j)}</span><span></span></div>`; }
	 * 
	 * // <<1주차>> j == firstDayName: 이번 달 시작 요일일 때 else if (i == 0 && j ==
	 * firstDayName - 1) { calHtml += `<div style='background-color:#FFE0BB;'
	 * class='calendar__day horizontalGutter
	 * verticalGutter'><span>${startDayCount}</span><span
	 * id='${year}${month}${setFixDayCount(startDayCount++)}'></span></div>`; }
	 * 
	 * //<<1주차>> j > firstDayName: 이번 달 시작 요일 이후 일 때 else if (i == 0 && j >
	 * firstDayName - 1) { calHtml += `<div style='background-color:#FFFFBB'
	 * class='calendar__day horizontalGutter verticalGutter
	 * '><span>${startDayCount}</span><span
	 * id='${year}${month}${setFixDayCount(startDayCount++)}'></span></div>`; }
	 * 
	 * // startDayCount <= lastDay: 이번 달의 마지막 날이거나 이전일 때 else if (i > 0 &&
	 * startDayCount <= lastDay) { calHtml += `<div
	 * style='background-color:#BBFFC9;'class='calendar__day horizontalGutter
	 * verticalGutter'><span>${startDayCount}</span><span
	 * id='${year}${month}${setFixDayCount(startDayCount++)}'></span></div>`; }
	 * 
	 * // startDayCount > lastDay: 이번 달의 마지막 날 이후일 때 else if (startDayCount >
	 * lastDay) { calHtml += `<div style='background-color:#B9E1FF;'
	 * class='calendar__day horizontalGutter
	 * verticalGutter'><span>${lastDayCount++}</span><span></span></div>`; } }
	 * 
	 * } //캘린더 div 태그에 내용 붙임 document.querySelector("#calendar").prepend(calHtml);
	 * };
	 * 
	 * const setFixDayCount=number=> { //캘린더 하루마다 아이디를 만들어주기 위해 사용 let fixNum = "";
	 * if (number < 10) { fixNum = "0" + number; } else { fixNum = number; } return
	 * fixNum; };
	 * 
	 * if(today.getMonth()+1<10) { setCalendarData(today.getFullYear(), "0" +
	 * (today.getMonth() + 1)); }else { setCalendarData(today.getFullYear(), "" +
	 * (today.getMonth() + 1)); }
	 */


	public static void main(String[] args) {
        Calendar nowCal = Calendar.getInstance();//현재날짜 2021-09-18-토(7)
        int year = nowCal.get(Calendar.YEAR); // Calendar 인스턴스에 있는 저장된 필드 값을 가져옴 
        int month = nowCal.get(Calendar.MONTH); 
        int day = nowCal.get(Calendar.DATE); 
        int dayOfWeek = nowCal.get(Calendar.DAY_OF_WEEK);//요일 1~7
        int lastDay = nowCal.getActualMaximum(Calendar.DATE); // 해당 월의 마지막 일(date)를 반환
        System.out.println("nowCal : "+year+"년"+month+"월"+day+"일"+dayOfWeek+"요일");
        
        Calendar firstCal = new GregorianCalendar();//현재 달의 첫번째 날j
        firstCal=nowCal;
        firstCal.set(Calendar.DATE, 1);     
        int firstDayName=firstCal.get(Calendar.DAY_OF_WEEK);
        System.out.println("firstCal : "+firstCal.get(Calendar.YEAR)+"년"+firstCal.get(Calendar.MONTH)+"월"+firstCal.get(Calendar.DATE)+"일"+firstDayName+"요일");
        System.out.println("firstDayName : "+firstDayName);
        Calendar preCal = new GregorianCalendar();//이전달의 첫번째날
        if(month==1) {
        	preCal.set(Calendar.YEAR, year-1);
        	preCal.set(Calendar.MONTH, 11);//12월
        }else {
        	preCal.set(Calendar.YEAR, year);
        	preCal.set(Calendar.MONTH, month-1);
        }
        preCal.set(Calendar.DATE, 1);
        System.out.println("preCal : "+preCal.get(Calendar.YEAR)+"년"+preCal.get(Calendar.MONTH)+"월"+preCal.get(Calendar.DATE)+"일"+preCal.get(Calendar.DAY_OF_WEEK)+"요일");
        
        int yearPre = preCal.get(Calendar.YEAR); 
        int monthPre = preCal.get(Calendar.MONTH); 
        int dayPre = preCal.get(Calendar.DATE);
        int lastDayPre = preCal.getActualMaximum(Calendar.DATE); // 해당 월의 마지막 일(date)를 반환
        
        String calHtml=new String();
        int startDayCount=1;
        int lastDayCount=1;
        /*
        for (int i = 0; i < 6; i++) {//1~6주차를 위해 6번 반복        
    		for (int j = 0; j < 7; j++) {//일요일~토요일을 위해 7번 반복
    			// <<1주차>> j < firstDayName: 이번 달 시작 요일 이전 일 때
    			if (i == 0 && j < firstDayName - 2) {
    				calHtml +="<div style='background-color:#FFB3BB;' class='calendar__day horizontalGutter verticalGutter'><span>"
    						+(lastDayPre - (firstDayName -3) + j)+"</span><span></span></div>";
    				System.out.println("a<div style='background-color:#FFB3BB;' class='calendar__day horizontalGutter verticalGutter'><span>"
    						+(lastDayPre - (firstDayName -3) + j)+"</span><span></span></div>");
    			}
    			
    			// <<1주차>> j == firstDayName: 이번 달 시작 요일이거나 이후일때
    			else if (i == 0 && j >= firstDayName -4) {
    				calHtml += "<div style='background-color:#BBFFC9;' class='calendar__day horizontalGutter verticalGutter'><span>"+
    						+startDayCount+"</span><span id='"+year+month+String.format("%02d", startDayCount++)+"'></span></div>";
    				System.out.println("b<div style='background-color:#BBFFC9;' class='calendar__day horizontalGutter verticalGutter'><span>"+
    						+startDayCount+"</span><span id='"+year+month+String.format("%02d", startDayCount)+"'></span></div>");
    			}
    			
    			// startDayCount <= lastDay: 이번 달의 마지막 날이거나 이전일 때
    			else if (i > 0 && startDayCount <= lastDay) {
    				calHtml += "<div style='background-color:#BBFFC9;'class='calendar__day horizontalGutter verticalGutter'><span>"
    						+startDayCount+"</span><span id='"+year+month+String.format("%02d", startDayCount++)+"'></span></div>";
    				System.out.println("c<div style='background-color:#BBFFC9;'class='calendar__day horizontalGutter verticalGutter'><span>"
    						+startDayCount+"</span><span id='"+year+month+String.format("%02d", startDayCount)+"'></span></div>");
    			}

    			// startDayCount > lastDay: 이번 달의 마지막 날 이후일 때
    			else if (startDayCount > lastDay) {
    				calHtml += "<div style='background-color:#B9E1FF;' class='calendar__day horizontalGutter verticalGutter'><span>"
    						+(lastDayCount++)+"</span><span></span></div>";  		
    				System.out.println("d<div style='background-color:#B9E1FF;' class='calendar__day horizontalGutter verticalGutter'><span>"
    						+(lastDayCount)+"</span><span></span></div>");
    			}
    		}
    	}
        */
        
	}

}
