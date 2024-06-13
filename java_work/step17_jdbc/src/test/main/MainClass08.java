package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao("scott", "tiger");

		var member = dao.select(10);
		System.out.println(member.getNum() + " " + member.getName() + " " + member.getAddr());
		System.out.println(dao.insert(new MemberDto(0, "ㅁㅁㅁ", "aaa")));
		System.out.println(dao.update(new MemberDto(1, "ㅁㅁㅁ", "aaa")));

		for (var mem : dao.getMembers()) {
			System.out.println(mem.getNum() + " " + mem.getName() + " " + mem.getAddr());
		}
		dao.getMembers();
	}
}