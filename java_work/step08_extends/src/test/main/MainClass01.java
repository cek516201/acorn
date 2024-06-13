package test.main;

import test.mypac.HandPhone;

public class MainClass01 {
	public static void main(String[] args) {
		// phone과 handHphone 둘 다 생성됨
		HandPhone p1 = new HandPhone();
		p1.call();
		p1.mobileCall();
		p1.takePicture();
	}
}