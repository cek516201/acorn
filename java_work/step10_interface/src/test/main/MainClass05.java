package test.main;

import test.mypac.Calculator;

public class MainClass05 {
	public static void main(String[] args) {
		Calculator c1 = null;
		Calculator c2 = new Calculator() {
			@Override
			public double execute(double num1, double num2) {
				return num1 + num2;
			}
		};

		Calculator add = (num1, num2) -> {
			return num1 + num2;
		};
		double result1 = add.execute(1, 2);

		// 중괄호 안에서 실행할 코드가 없다면 중괄호 생략
		// return 생략 후 리턴할 값만 명시하면 된다
		Calculator add2 = (num1, num2) -> num1 + num2; // 한줄짜리 함수모양을 람다식이라고도 한다
		Calculator sub = (num1, num2) -> num1 - num2;
		Calculator mul = (num1, num2) -> num1 * num2;
		Calculator div = (num1, num2) -> num1 / num2;
		double result2 = sub.execute(10, 10);
		double result3 = mul.execute(2, 8);
		double result4 = div.execute(11, 2);
	}
}