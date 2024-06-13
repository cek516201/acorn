package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 회원의 번호:");

		MemberDao dao = new MemberDao("scott", "tiger");
		MemberDto mem = dao.select(scan.nextInt());
		if (mem != null) {
			System.out.printf("%d %s %s", mem.getNum(), mem.getName(), mem.getAddr());
		} else {
			System.out.println("회원이 없습니다");
		}
	}
}