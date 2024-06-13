package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		// Remocon r1 = new Remocon(); // 단독 객체 생성 불가
		Remocon r1 = null;
		// r1.up(); // 널 포인터 에러

		Remocon r2 = new MyRemocon();
		r2.up();
		r2.down();
		System.out.println(Remocon.COMPANY);
		// Remocon.COMPANY = "SAMSUNG"; // 수정 불가(final)

		int num1 = 10;
		num1 = 20;
		final int num2 = 10;
		// num2 = 20;
		final String NICK = "asd";
		// NICK = "ㅁㄴㅇ";

		final Remocon r3 = new MyRemocon();
		// r3 = new MyRemocon();
	}
}