package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		Object p1 = new HandPhone();
		// 캐스팅하면 자식에 대입 가능
		Phone p2 = (Phone) p1;
		HandPhone p3 = (HandPhone) p2;
	}
}