package test.main;

import java.util.HashSet;
import java.util.Set;

// HashSet은 set 인터페이스를 구현한 클래스이다

// 순서가 없다
// key값도 없다
// 중복을 허용하지 않는다
// 어떤 data를 묶음으로 관리하고자 할 때 사용한다

public class MainClass10 {
	public static void main(String[] args) {
		// 정수를 저장할 수 있는 HashSet 객체를 생성해서 참조값을 Set 인터페이스 type 지역변수에 담기
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(10);
		intSet.add(20);
		intSet.add(30);

		Set<String> strSet = new HashSet<String>();
		strSet.add("ㅁㅁㅁ");
		strSet.add("ㄴㄴㄴ");
		strSet.add("ㅇㅇㅇ");

		intSet.forEach((elem) -> {
			System.out.print(elem + " ");
		});
		System.out.println();

		strSet.forEach((elem) -> {
			System.out.print(elem + " ");
		});

		// 데이터 존재 여부
		boolean isContain = strSet.contains("ㅁㄴㅇ");
		int size = strSet.size();
		strSet.remove("ㅁㄴㅇ");
		strSet.clear();
	}
}