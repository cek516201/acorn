package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		Weapon w1 = new Weapon() { // 익명 클래스
			@Override
			public void attack() {
				System.out.println("익명 class attack");
			}
		};

		useWeapon(new Weapon() { // 익명 클래스
			@Override
			public void attack() {
				System.out.println("익명 class attack");
			}
		});
	}

	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}