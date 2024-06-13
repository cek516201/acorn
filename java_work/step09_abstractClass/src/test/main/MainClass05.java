package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		Weapon w1 = new SeaWeapon();
		w1.attack();

		// local inner class
		class SpaceWeapon extends Weapon {
			@Override
			public void attack() {
				System.out.println("space weapon attack");
			}
		}
		Weapon w2 = new SpaceWeapon();
		w2.attack();
	}

	// inner class
	public static class SeaWeapon extends Weapon {
		@Override
		public void attack() {
			System.out.println("sea weapon attack");
		}
	}
}