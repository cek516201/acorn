package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	public static void main(String[] args) {
		// DB 연결객체를 담을 지역 변수 만들기
		conn = new DBConnector("scott", "tiger").getConnection();

		MainClass07.insert(new MemberDto(0, "ㅁㅁㅁ", "aaa"));
	}

	public static void insert(MemberDto dto) {
		try (PreparedStatement ps = conn
				.prepareStatement("insert into member" + " values(member_seq.NEXTVAL, ?, ?)");) {

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			System.out.println(ps.executeUpdate() + "개의 회원 정보를 저장했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection conn = null;
}