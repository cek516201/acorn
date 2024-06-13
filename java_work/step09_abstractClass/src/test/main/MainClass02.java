package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		test(); // 동일한 클래스에 있으면 클래스명 생략 가능
		printString("asd");
		useWeapon(new MyWeapon());
	}

	public static void test() {
		System.out.println("test");
	}

	public static void printString(String msg) {
		System.out.println("String : " + msg);
	}

	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}