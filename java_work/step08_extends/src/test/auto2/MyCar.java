package test.auto2;

import test.auto.Car;
import test.auto.Engine;

public class MyCar extends Car {
	public MyCar(Engine engine) {
		super(engine);
	}

	public void myDrive() {
		if (this.engine == null) {
			System.out.println("Engine이 없음");
			return;
		}
		System.out.println("my drive");
	}
}