package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass02 {
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

//		// SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역 변수 만들기
//		PreparedStatement ps = null;

		try (PreparedStatement ps = conn.prepareStatement("insert into member" + " values(?, ?, ?)");) {
//			// 실행할 sql문
//			String sql = "insert into member" + " values(?, ?, ?)";
//			// PreparedStatement 객체의 참조값 얻어오기
//			ps = conn.prepareStatement(sql);

			// PrepareStatement 객체의 메소드를 이용해서 미완성인 sql문을 완성시키기(?에 값 바인딩)
			ps.setInt(1, 1); // 1번째 ?에 숫자 바인딩
			ps.setString(2, "ㅁㅁㅁ"); // 2번째 ?에 문자열 바인딩
			ps.setString(3, "aaa"); // 3번째 ?에 문자열 바인딩
			// sql문 실행하기
			System.out.println(ps.executeUpdate() + "개의 회원 정보를 저장했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}