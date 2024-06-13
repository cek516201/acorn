package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		// Weapon w1 = new Weapon(); // 추상클래스 단독으로 객체 생성 불가
		Weapon w1 = null; // 데이터 타입의 역할은 할 수 있다
		// w1.attack(); // 널 포인터 에러

		Weapon w2 = new MyWeapon();
		w2.prepare();
		w2.attack();
	}
}