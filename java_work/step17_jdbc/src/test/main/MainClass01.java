package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *  JDBC ( Java DataBase Connectivity )
 *  
 *  DataBase 에 연결해서 SELECT, INSERT, UPDATE, DELETE 작업하기
 *  
 *  Oracle 에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc11.jar 파일을
 *  사용할수 있도록 설정해야 한다.
 *  
 *  프로젝트에 마우스 우클릭 => Build Path => Configure Build Path => Librarys 탭 선택
 *  => classpath 선택 => 우측 Add External jar 버튼을 누른후 => ojdbc11.jar 파일을 찾은다음 => Apply 
 */ 

public class MainClass01 {
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
//		ResultSet rs = null;

		try (PreparedStatement ps = conn.prepareStatement("select empno, ename, job, sal from emp order by empno asc");
				ResultSet rs = ps.executeQuery();) {
//			// 실행할 sql문
//			String sql = "select empno, ename, job, sal" + " from emp" + " order by empno asc";
//			// PreparedStatement 객체의 참조값 얻어오기
//			ps = conn.prepareStatement(sql);
//			// SELECT문 실행하고 결과 값을 ResultSet으로 얻어내기
//			rs = ps.executeQuery();
			
			while (rs.next()) {
				// 현재 cursor가 위치한 곳의 숫자나 문자를 추출한다
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				System.out.println(empno + "   " + ename + "   " + job + "   " + sal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}
}