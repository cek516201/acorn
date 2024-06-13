package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

// 지역변수나 필드 앞에 선언하는 데이터 타입은 참조값의 사용설명서
// 설명서에 명시된 기능만 사용 가능
// 모든 객체는 다형성(타입이 여러개)을 가질수 있음

public class MainClass02 {
	public static void main(String[] args) {
		HandPhone p1 = new HandPhone(); // object, phone, handPhone 사용 가능
		Phone p2 = new HandPhone(); // object, phone 사용 가능
		Object p3 = new HandPhone(); // object 사용 가능
	}
}