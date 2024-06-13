package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		String inputNum = scan.nextLine();

		try {
			double num = Double.parseDouble(inputNum);
			double result = num + 100;
			System.out.println("입력한 숫자 + 100 : " + result);
		} catch (NumberFormatException e) {
			// 실행 스택에서 일어난 일을 콘솔창에 출력하기
			// (자세한 예외 정보를 예외객체가 콘솔창에 출력하게 하기)
			e.printStackTrace();
		}

		System.out.println("중요한 작업");
	}
}