package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		// 부모 타입 변수나 필드에 대입 가능
		HandPhone p1 = new HandPhone();
		Phone p2 = p1;
		Object p3 = p2;
	}
}