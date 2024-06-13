package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();

		Member m1 = new Member(1, "ㅁㅁㅁ", "aaa");
		Member m2 = new Member(2, "ㄴㄴㄴ", "sss");
		Member m3 = new Member();

		memList.add(m1);
		memList.add(m2);
		memList.add(m3);

		for (var elem : memList) {
			System.out.println("번호:" + elem.getNum() + " 이름:" + elem.getName() + " 주소:" + elem.getAddr());
		}
	}
}