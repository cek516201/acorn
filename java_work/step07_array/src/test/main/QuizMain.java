package test.main;

import java.util.Random;

public class QuizMain {
	public static void main(String[] args) {
		String[] datas = { "cherry", "apple", "banana", "melon", "7" };
		int datasIndex = new Random().nextInt(0, datas.length);
		System.out.println(datas[datasIndex]);
	}
}