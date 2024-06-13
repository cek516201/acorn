package test.main;

/* 기본 데이터 타입의 참조 데이터 타입
 * byte : Byte
 * short : Short
 * int : Int
 * long : Long
 * 
 * float : Float
 * double : Double
 * 
 * char : Character
 * boolean : Boolean
 * 
 * 기본 데이터 타입을 객체에 포장(boxing)하는 형태
 * boxing과 unboxing 자동 */

public class MainClass01 {
	public static void main(String[] args) {
		int num1 = 10;
		// Integer num2 = new Integer(10);
		Integer num2 = 10; // 자동으로 박싱됨

		// 참조 데이터 타입이지만 기본 데이터 타입처럼 사용할 수 있음
		int result1 = num2 + 1; // 자동으로 언박싱됨
		int result2 = num1 + num2;
		Integer result3 = num1 + num2;
		String result = num2.toString();
		int result4 = Integer.parseInt("999");

	}
}