package test.main;

import java.util.Random;
import test.mypac.WowException;

public class MainClass08 {
	public static void main(String[] args) {
		Random ran = new Random();
		int ranNum = ran.nextInt(7, 9);
		if (ranNum == 7) {
			try {
				throw new WowException("wow exception");
			} catch (WowException e) {
				e.printStackTrace();
			}

		}

		System.out.println(ranNum);
	}
}