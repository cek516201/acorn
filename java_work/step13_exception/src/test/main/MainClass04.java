package test.main;

// RuntimeException을 상속받지 않은 Exception type은
// 반드시 try~catch 블럭으로 예외처리를 해야된다
public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 시작");

		try {
			// 스레드를 지연시키기(millisecond)
			Thread.sleep(1000);
		} catch (InterruptedException e) { // RuntimeException을 상속받지 않은 Exception
			e.printStackTrace();
		}

		System.out.println("main 종료");
	}
}