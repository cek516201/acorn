package test.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.guest.dto.GuestDto;
import test.util.DbcpBean;

// GuestDao 객체가 오직 한 개만 생성되어서 사용하도록 클래스를 설계
public class GuestDao {
	// 외부에서 객체를 생성하지 못하도록 생성자의 접근 지정자를 private로 설정
	private GuestDao() {}

	// static 초기화 블럭(이 클래스가 최초로 사용될 때 한번만 수행됨)
	static {
		GuestDao.dao = new GuestDao();
	}

	public GuestDto getData(int num) {
		GuestDto data = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection Pool 로 부터 Connection 객체 하나 가져오기
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 작성
			String sql = "select writer, content, pwd, regdate from board_guest where num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있으면 여기서 바인딩한다.
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new GuestDto(num,
									rs.getString("writer"),
									rs.getString("content"),
									rs.getString("pwd"),
									rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public boolean insert(GuestDto dto) {
		int rowCount = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "insert into board_guest values(board_guest_seq.NEXTVAL, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPwd());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rowCount > 0;
	}
	
	public boolean update(GuestDto dto) {
		int rowCount = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "update board_guest set writer=?, content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rowCount > 0;
	}
	
	public boolean delete(int num) {
		int rowCount = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "delete from board_guest where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return rowCount > 0;
	}

	public List<GuestDto> getList() {
		List<GuestDto> list = new ArrayList<GuestDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection Pool 로 부터 Connection 객체 하나 가져오기
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 작성
			String sql = "select num, writer, content, pwd, regdate from board_guest order by num desc";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있으면 여기서 바인딩한다.

			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new GuestDto(rs.getInt("num"),
									  rs.getString("writer"),
									  rs.getString("content"),
									  rs.getString("pwd"),
									  rs.getString("regdate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// static 필드에 저장된 GuestDao의 참조값을 리턴해주는 static 메소드
	public static GuestDao getInstance() {
		return GuestDao.dao;
	}

	// 자신의 참조값을 저장할 static 필드
	private static GuestDao dao;
}