package frame03;

public class CountRunnable implements Runnable {
	@Override
	public void run() {
		int count = 10;
		while (true) {
			System.out.println(count);
			if (count <= 0) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
	}
}