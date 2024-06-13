package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		car1.name = "소나타";
		car2.name = "그랜저";
		car1.drive();
		car2.drive();
		Car car3 = car2;
		System.out.println(car3 == car2);
	}
}