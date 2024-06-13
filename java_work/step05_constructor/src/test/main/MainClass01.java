package test.main;

import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 시작");

		// new Student()는 생성자를 호출하는 표현식
		Student s1 = new Student();
		s1.study();

		System.out.println("main 끝");
	}
}