package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		Remocon r1 = new Remocon() { // 익명 인터페이스
			@Override
			public void up() {
				System.out.println("up volume");
			}

			@Override
			public void down() {
				System.out.println("down volume");
			}
		};

		useRemocon(new Remocon() { // 익명 인터페이스
			@Override
			public void up() {
				System.out.println("down");
				down();
			}

			@Override
			public void down() {
				System.out.println("up");
				up();
			}
		});
	}

	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}