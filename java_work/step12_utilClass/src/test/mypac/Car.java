package test.mypac;

public class Car {
	public Car(String name) {
		this.name = name;
	}

	public void drive() {
		System.out.println(name + " drive");
	}

	private String name;
}