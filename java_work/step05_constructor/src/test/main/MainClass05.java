package test.main;

import java.util.Random;

public class MainClass05 {
	public static void main(String[] args) {
		Random ran = new Random();
		int num = ran.nextInt(21) - 10;
		int num2 = ran.nextInt(26) + 75;
		int num3 = ran.nextInt(45) + 1;
	}
}