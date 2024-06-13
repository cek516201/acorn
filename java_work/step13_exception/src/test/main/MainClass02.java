package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("나눌 수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.print("나누어지는 수 입력 : ");
		String inputNum2 = scan.nextLine();

		int num1 = 0;
		int num2 = 0;
		int result = 0;
		int result2 = 0;
		try {
			num1 = Integer.parseInt(inputNum1);
			num2 = Integer.parseInt(inputNum2);

			result = num2 / num1; // 몫
			result2 = num2 % num1; // 나머지

			System.out.printf("%d를 %d로 나눈 값 : %d\n", num2, num1, result);
			System.out.printf("%d를 %d로 나눈 나머지 : %d\n", num2, num1, result2);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

	}
}