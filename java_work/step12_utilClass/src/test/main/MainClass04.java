package test.main;

import java.util.ArrayList;
import java.util.List;
import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("a"));
		carList.add(new Car("b"));
		carList.add(new Car("c"));

		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).drive();
		}

		for (var car : carList) {
			car.drive();
		}

		carList.forEach((elem) -> {
			elem.drive();
		});
	}
}