package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 시작");

		// inputStream : 콘솔창에서 읽어들이기
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		String str = scan.next();

		System.out.println("main 끝");
	}
}