package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass05 {
	public static void main(String[] args) {
		AndroidPhone p1 = new AndroidPhone();
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		p1.doInternet();

		System.out.println("----------");
		HandPhone p2 = new AndroidPhone();
		p2.takePicture(); // androidPhone take picture

		System.out.println("----------");
		HandPhone p3 = new HandPhone();
		p3.takePicture(); // handPhone take picture
	}
}