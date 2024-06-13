package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		List<MemberDto> memList = new ArrayList<MemberDto>();
		var mem1 = new MemberDto(1, "ㅁㅁㅁ", "aaa");
		memList.add(mem1);

		var mem2 = new MemberDto(2, "ㄴㄴㄴ", "sss");
		memList.add(mem2);

		var mem3 = new MemberDto();
		memList.add(mem3);
		mem3.setNum(3);
		mem3.setName("ㅇㅇㅇ");
		mem3.setAddr("ddd");

		for (var elem : memList) {
			System.out.println("번호:" + elem.getNum() + " 이름:" + elem.getName() + " 주소:" + elem.getAddr());
		}
		System.out.println();

		// string 클래스의 format을 이용해서 문자열 형식 작성 가능
		// %d -> 정수
		// %s -> 문자
		// %f -> 실수
		// %b -> boolean
		// %% -> % 자체를 출력할때
		for (var elem : memList) {
			System.out.println(String.format("번호:%d 이름:%s 주소:%s", elem.getNum(), elem.getName(), elem.getAddr()));
		}
		System.out.println();

		test(memList, memList);
	}

	public static void test(List<MemberDto>... memMatrix) {
		for (var memList : memMatrix) {
			for (var elem : memList) {
				System.out.println(String.format("번호:%d 이름:%s 주소:%s", elem.getNum(), elem.getName(), elem.getAddr()));
			}
		}
	}
}