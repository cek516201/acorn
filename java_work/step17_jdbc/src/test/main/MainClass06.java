package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import test.util.DBConnector;

public class MainClass06 {
	public static void main(String[] args) {
		// DB 연결객체를 담을 지역 변수 만들기
		Connection conn = new DBConnector("scott", "tiger").getConnection();

		try (PreparedStatement ps = conn
				.prepareStatement("insert into member" + " values(member_seq.NEXTVAL, ?, ?)");) {

			ps.setString(1, "ㅁㅁㅁ");
			ps.setString(2, "aaa");
			System.out.println(ps.executeUpdate() + "개의 회원 정보를 저장했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}