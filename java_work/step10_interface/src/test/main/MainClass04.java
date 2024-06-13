package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(() -> {
			System.out.println("자바스크립트식 함수전달");
		});

		useDrill(new Drill() { // 익명 인터페이스
			@Override
			public void hole() {
				System.out.println("잠크리트 발파");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hole();
			}
		});
	}

	public static void useDrill(Drill d) {
		d.hole();
	}
}