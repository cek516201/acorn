package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnector;

// data access object
public class MemberDao {
	public MemberDao(String id, String password) {
		conn = new DBConnector(id, password).getConnection();
	}

	public MemberDto select(int num) {
		MemberDto member = null;
		try (PreparedStatement ps = conn.prepareStatement("select * from member where num=?");) {
			ps.setInt(1, num);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next())
					member = new MemberDto(rs.getInt("num"), rs.getString("name"), rs.getString("addr"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	public boolean insert(MemberDto dto) {
		int rowCount = 0;
		try (PreparedStatement ps = conn.prepareStatement("insert into member values(member_seq.NEXTVAL, ?, ?)");) {
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			rowCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}

	public boolean delete(int num) {
		int rowCount = 0;
		try (PreparedStatement ps = conn.prepareStatement("delete from member where num=?");) {
			ps.setInt(1, num);
			rowCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}

	public boolean update(MemberDto dto) {
		int rowCount = 0;
		try (PreparedStatement ps = conn.prepareStatement("update member set name=?, addr=? where num=?");) {
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			ps.setInt(3, dto.getNum());
			rowCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount > 0;
	}

	public List<MemberDto> getMembers() {
		List<MemberDto> members = new ArrayList<MemberDto>();
		try (PreparedStatement ps = conn.prepareStatement("select * from member order by num asc");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				members.add(new MemberDto(rs.getInt("num"), rs.getString("name"), rs.getString("addr")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return members;
	}

	private Connection conn = null;
}