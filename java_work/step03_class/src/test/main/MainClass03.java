package test.main;

import test.mypac.Car;

public class MainClass03 {
	public static void main(String[] args) {
		new Car();

		new Car().drive();

		Car c1 = new Car();
		c1.drive();

		// String word = new String("kimgura"); 의 간략화
		String word = "kimgura";
	}
}
