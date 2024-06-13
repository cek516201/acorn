package test.auto;

// public : 어디에서나 접근 가능
// protected : 동일한 패키지 또는 자식에서 접근 가능
// default : 동일한 패키지에서 접근 가능
// private : 동일한 클래스 혹은 동일한 객체에서 접근 가능

// 접근지정자 위치
// 1. 클래스 선언
// 2. 생성자
// 3. 필드
// 4. 메소드

// 클래스는 public or default만 가능
// import 가능 여부
public class Car {
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		if (engine == null) {
			System.out.println("Engine이 없음");
			return;
		}
		System.out.println("drive");
	}

	protected Engine engine;
}