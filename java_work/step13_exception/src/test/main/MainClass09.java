package test.main;

public class MainClass09 {
	public static void main(String[] args) {
		int minute = 0, second = 0;
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (++second >= 60) {
				minute += second / 60;
				second %= 60;
			}

			if (minute > 0) {
				System.out.print(minute + "분 ");
			}
			System.out.println(second + "초");
		}
	}
}