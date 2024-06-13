package test.friend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.friend.dto.FriendDto;
import test.util.DbcpBean;

public class FriendDao {
	public FriendDto select(int num) {
		FriendDto friend = null;

		try (Connection conn = new DbcpBean().getConn();
			 PreparedStatement pstmt = conn.prepareStatement("select name, phoneNumber from friend where num=?")) {
			pstmt.setInt(1, num);
			try(ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					friend = new FriendDto(num, rs.getString("name"), rs.getString("phoneNumber"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return friend;
	}

	public boolean insert(FriendDto dto) {
		int rowCount = 0;

		try (Connection conn = new DbcpBean().getConn();
				PreparedStatement pstmt = conn
						.prepareStatement("insert into friend values(friend_seq.NEXTVAL, ?, ?)")) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoneNumber());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}

	public boolean delete(int num) {
		int rowCount = 0;

		try (Connection conn = new DbcpBean().getConn();
				PreparedStatement pstmt = conn.prepareStatement("delete from friend where num=?")) {
			pstmt.setInt(1, num);
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}

	public boolean update(FriendDto dto) {
		int rowCount = 0;

		try(Connection conn = new DbcpBean().getConn();
			PreparedStatement pstmt = conn.prepareStatement("update friend set name=?, phoneNumber=? where num=?")) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoneNumber());
			pstmt.setInt(3, dto.getNum());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}
	
	public List<FriendDto> getDatas() {
		List<FriendDto> datas = new ArrayList<>();

		try (Connection conn = new DbcpBean().getConn();
				PreparedStatement pstmt = conn
						.prepareStatement("select num, name, phoneNumber from friend order by num asc");
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				datas.add(new FriendDto(rs.getInt("num"), rs.getString("name"), rs.getString("phoneNumber")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datas;
	}
}