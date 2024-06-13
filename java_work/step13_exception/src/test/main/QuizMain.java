package test.main;

public class QuizMain {
	public static void main(String[] args) {
		int num = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(++num + "초");
			if (num >= 10) {
				break;
			}
		}
	}
}