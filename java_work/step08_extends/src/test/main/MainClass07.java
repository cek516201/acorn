package test.main;

import test.mypac.Phone;
import java.util.Scanner;

public class MainClass07 {
	public static void main(String[] args) {
		// 모든 데이터는 object 타입에 담을 수 있다
		Object a = 10;
		Object b = true;
		Object c = 'a';
		Object d = "abc";
		Object e = new Phone();
		Object f = new Scanner(System.in);

		Object[] objs = new Object[5];
		objs[0] = 10;
		objs[1] = true;
		objs[2] = "abc";
		objs[3] = new Phone();
		objs[4] = new Scanner(System.in);

		((Phone) e).call();
		((Phone) objs[3]).call();
	}
}