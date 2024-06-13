package test.mypac;

public class AndroidPhone extends HandPhone {
	public AndroidPhone() {
		System.out.println("androidPhone 생성자");
	}

	@Override
	public void takePicture() {
		// super.takePicture(); // super : 부모
		System.out.println("androidPhone take picture");
	}

	public void doInternet() {
		System.out.println("do internet");
	}
}