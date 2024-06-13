package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass08 {
	public static void main(String[] args) {
		Car car1 = new Car(new Engine());
		car1.drive();
	}
}