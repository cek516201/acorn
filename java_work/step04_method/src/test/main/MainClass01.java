package test.main;

import test.mypac.AirPlane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		t.walk();
		int num = t.getNumber();
		String word = t.getGreeting();
		AirPlane c = t.getAirPlane();
		c.fly();
		t.setNum(1);
		t.setName("a");
		t.setPlane(c);
		t.doSomething(2, "b", new AirPlane());

		t.send();
		t.send(1);
		t.send("a");
		t.send(new AirPlane());
	}
}