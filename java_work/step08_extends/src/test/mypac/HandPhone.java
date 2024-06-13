package test.mypac;

//                       상속
public class HandPhone extends Phone {
	public HandPhone() {
		System.out.println("handPhone 생성자");
	}

	public void mobileCall() {
		System.out.println("mobile call");
	}

	public void takePicture() {
		System.out.println("handPhone take picture");
	}
}