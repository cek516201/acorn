package test.mypac;

// 접근 지정자(public, protected, private, default)
// static or non-static
// 리턴 type
// 메소드 명
// 메소드 매개변수, type

public class Test {
	public void walk() {
		System.out.println("walk");
	}

	public int getNumber() {
		int num = 10;
		return num;
	}

	public String getGreeting() {
		return "greeting";
	}

	public AirPlane getAirPlane() {
		return new AirPlane();
	}

	public void setNum(int num) {

	}

	public void setName(String name) {

	}

	public void setPlane(AirPlane plane) {

	}

	public void doSomething(int num, String name, AirPlane plane) {

	}

	// 함수 다중정의(overloading)
	public void send() {
		System.out.println("send");
	}

	public void send(int num) {
		System.out.println("send " + num);
	}

	public void send(String name) {
		System.out.println("send " + name);
	}

	public void send(AirPlane plane) {
		System.out.println("send plane");
	}
}