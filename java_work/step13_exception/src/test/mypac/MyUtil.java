package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초동안 그림을 그리는 중");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("그림 완성");
	}

	public static void send() throws InterruptedException {
		System.out.println("5초동안 전송하는 중");
		Thread.sleep(5000);
		System.out.println("전송 완료");
	}
}