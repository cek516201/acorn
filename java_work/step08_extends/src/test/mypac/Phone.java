package test.mypac;

// 상속받지 않으면 자동으로 Object를 상속받음
public class Phone {
	public Phone() {
		System.out.println("phone 생성자");
	}

	public void call() {
		System.out.println("phone call");
	}
}