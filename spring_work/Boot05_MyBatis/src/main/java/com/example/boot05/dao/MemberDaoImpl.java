package com.example.boot05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot05.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list = session.selectList("member.getList");
		
		return list;
	}
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
	}
	
	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}
	
	@Override
	public MemberDto select(int num) {
		MemberDto dto = session.selectOne("member.select", num);

		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}
	
	@Autowired
	private SqlSession session;
}