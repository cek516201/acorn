package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao {
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list = session.selectList("cafe.getList", dto);
		
		return list;
	}

	@Override
	public int getCount(CafeDto dto) {
		int count = session.selectOne("cafe.getCount", dto);
		
		return count;
	}

	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override
	public CafeDto getData(int num) {
		CafeDto dto = session.selectOne("cafe.getData", num);
		
		return dto;
	}

	@Override
	public CafeDto getDetail(CafeDto dto) {
		CafeDto cafeDto = session.selectOne("cafe.getDetail", dto);
		
		return cafeDto;
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update", dto);
	}

	
	@Autowired
	private SqlSession session;
}
