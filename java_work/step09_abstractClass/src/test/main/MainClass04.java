package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		Gura g = new Gura();
		g.say();

		// 메소드 안에서 클래스를 정의할 수 있다
		// 여기 정의한 클래스는 메소드 안쪽 영역에서만 사용할 수 있다
		// 메소드 안에 정의한 클래스는 Local Inner Class라고 한다
		class Cat {
			public void say() {
				System.out.println("cat say");
			}
		}
		Cat c = new Cat();
		c.say();
	}

	// static 메소드 안에서 사용하려면 static 예약어가 필요
	public static class Gura {
		public void say() {
			System.out.println("gura say");
		}
	}
}