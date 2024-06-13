package frame01;

// 새로운 스레드 만드는 방법
// 1. Thread 클래스를 상속받은 클래스를 정의한다
// 2. run() 메소드를 오버라이드 한다
// 3. run() 메소드 안에서 새로운 스레드에서 해야 할 작업을 코딩한다
// 4. 만든 클래스를 객체로 생성하고 해당 객체의 start() 메소드를 호출하면 새로운 스레드가 시작된다

public class WorkThread extends Thread {
	@Override
	public void run() {
		System.out.println("sleep 10초");
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("sleep 끝");
	}
}