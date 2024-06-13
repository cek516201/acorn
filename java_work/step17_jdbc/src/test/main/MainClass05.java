package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass05 {
	public static void main(String[] args) {
		// DB 연결객체를 담을 지역 변수 만들기
		Connection conn = null;
		try {
			// 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속할 DB의 정보 @아이피주소:port번호:db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// System.out.println("접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

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