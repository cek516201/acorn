package test.main;

import test.mypac.Member;

public class MainClass06 {
	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member();
		Member m3 = new Member();
		m1.num = 1;
		m1.name = "ㅁㅁㅁ";
		m1.addr = "aaa";
		m2.num = 2;
		m2.name = "ㄴㄴㄴ";
		m2.addr = "sss";
		m1.showInfo();
		m2.showInfo();
		m3.showInfo();
	}
}