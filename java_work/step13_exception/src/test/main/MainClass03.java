package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("나눌 수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.print("나누어지는 수 입력 : ");
		String inputNum2 = scan.nextLine();

		try {
			int num1 = Integer.parseInt(inputNum1);
			int num2 = Integer.parseInt(inputNum2);

			int result = num2 / num1; // 몫
			int result2 = num2 % num1; // 나머지

			System.out.printf("%d를 %d로 나눈 값 : %d\n", num2, num1, result);
			System.out.printf("%d를 %d로 나눈 나머지 : %d\n", num2, num1, result2);
		} catch (Exception e) {
			System.out.println("예외 메시지 : " + e.getMessage());
		} finally {
			// 여기는 예외가 발생을 하던지 말던지 반드시 실행이 보장되는 블럭이다
			// 중요한 마무리 작업을 여기서 주로 수행한다
			System.out.println("마무리 작업");
		}
		System.out.println("main 종료");
	}
}