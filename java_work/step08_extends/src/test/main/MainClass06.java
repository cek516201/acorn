package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass06 {
	public static void main(String[] args) {
		HandPhone p1 = new HandPhone();
		AndroidPhone p2 = (AndroidPhone) p1; // 캐스팅 에러
		p2.doInternet();
	}
}