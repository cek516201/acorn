package test.main;

import java.util.Random;

import test.mypac.WowException;

public class MainClass07 {
	public static void main(String[] args) {
		Random ran = new Random();
		int ranNum = ran.nextInt(7, 9);
		if (ranNum == 7) {
			// 여기서 발생하는 예외는 JVM이 처리
			throw new WowException("wow exception");
		}

		System.out.println(ranNum);
	}
}