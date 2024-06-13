package test.main;

import test.mypac.Remocon;

public class MainClass04_1 {
	public static void main(String[] args) {
		Remocon r1 = new AirconRemocon();
		r1.up();
		r1.down();

		// local inner interface
		class CatRemocon implements Remocon {
			@Override
			public void up() {
				System.out.println("on cat");
			}

			@Override
			public void down() {
				up();
			}
		}
		Remocon r2 = new CatRemocon();
		r2.up();
		r2.down();
	}

	// inner interface
	public static class AirconRemocon implements Remocon {
		@Override
		public void up() {
			System.out.println("on aircon");
		}

		@Override
		public void down() {
			System.out.println("off aircon");
		}

	}
}