package test.main;

import java.util.Random;

public class MainClass04 {
	public static void main(String[] args) {
		Random ran = new Random();
		int num = ran.nextInt();
		System.out.println(num);
		
		int num2 = ran.nextInt(10); // 10 미만
		System.out.println(num2);
	}
}