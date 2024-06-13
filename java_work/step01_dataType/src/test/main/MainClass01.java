/*  [ Java 기본 데이터 type ]
 *  
 *  1. 숫자형
 *  
 *  정수형 : byte, short, int, long
 *  
 *  - byte 변수명; // -128 ~ 127
 *  - short 변수명; // -32768 ~ 32767
 *  - int 변수명; // -2,147,483,648 ~ 2,147,483,647
 *  - long 변수명; // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *  
 *  실수형 : float, double
 *  
 *  - float 변수명; // 1.40129846432481707e-45 ~ 3.40282346638528860e+38
 *  - double 변수명; // 4.94065645841246544e-324d ~ 1.79769313486231570e+308d
 */

package test.main;

// class의 이름이 MainClass01 (파일명와 클래스명은 같아야함)
public class MainClass01 {
	// 실행할 때 시작되는 main 메소드
	public static void main(String[] args) {
		byte iByte = 10;
		short iShort = 10;
		int iInt = 1000;
		long iLong = 10000;

		int tmp = iShort; // int는 short보다 범위가 더 넓으므로 대입 가능
		byte tmp2 = (byte) iShort; // 범위가 좁은 변수에 대입하려면 캐스팅

		float num1 = 10.1f;
		double num2 = 10.2d;
		double num3 = 10.3; // d,f를 붙이지 않으면 double로 간주

		double tmp3 = num1;
		float tmp4 = (float) num2;
	}
}