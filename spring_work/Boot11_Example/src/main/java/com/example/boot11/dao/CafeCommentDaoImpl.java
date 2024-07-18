package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.CafeCommentDto;

@Repository
public class CafeCommentDaoImpl implements CafeCommentDao {
	@Override
	public int getSequence() {
		int sequence = session.selectOne("cafeComment.getSequence");
		
		return sequence;
	}

	@Override
	public void insert(CafeCommentDto dto) {
		session.insert("cafeComment.insert", dto);
	}

	@Override
	public List<CafeCommentDto> getList(CafeCommentDto dto) {
		List<CafeCommentDto> list = session.selectList("cafeComment.getList", dto);
		
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("cafeComment.delete", num);
	}

	@Override
	public CafeCommentDto getData(int num) {
		CafeCommentDto dto = session.selectOne("cafeComment.getData", num);
		
		return dto;
	}

	@Override
	public void update(CafeCommentDto dto) {
		session.update("cafeComment.update", dto);
	}

	@Override
	public int getCount(int ref_group) {
		int count = session.selectOne("cafeComment.getCount", ref_group);
		
		return count;
	}
	
	@Autowired
	private SqlSession session;
}