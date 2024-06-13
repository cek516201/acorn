package test.main;

import test.mypac.Square;

public class MainClass08 {
	public static void main(String[] args) {
		Square s1 = new Square();
		Square s2 = new Square();
		s1.width = s1.height = 10;
		s2.width = s2.height = 20;
		s1.showArea();
		s2.showArea();
	}
}