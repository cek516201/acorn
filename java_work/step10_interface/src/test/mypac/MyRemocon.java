package test.mypac;

public class MyRemocon implements Remocon {
	@Override
	public void up() {
		System.out.println("up channel");
	}

	@Override
	public void down() {
		System.out.println("down channel");
	}
}
