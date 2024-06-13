package test.mypac;

public class Zoo {
	public Monkey getMonkey() {
		return new Monkey();
	}

	public Tiger getTiger() {
		return new Tiger();
	}

	// 내부 클래스(inner class)
	public class Monkey {
		public void say() {
			System.out.println("monkey say");
		}
	}

	public class Tiger {
		public void say() {
			System.out.println("tiger say");
		}
	}
}