package test.auto;

public class SportsCar extends Car {
	public SportsCar(Engine engine) {
		// 부모 생성자
		// super(engine) 실행 전에 다른 코드가 있으면 안됨
		super(engine);
	}

	public void openDrive() {
		if (this.engine == null) {
			System.out.println("Engine이 없음");
			return;
		}
		System.out.println("open drive");
	}
}