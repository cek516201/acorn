package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao {
	@Override
	public List<FileDto> getList(FileDto dto) {
		List<FileDto> list = session.selectList("file.getList", dto);
		
		return list;
	}
	
	@Override
	public void delete(int num) {
		session.delete("file.delete", num);
	}

	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert", dto);
	}
	
	@Override
	public FileDto select(int num) {
		FileDto dto = session.selectOne("file.select", num);
		
		return dto;
	}
	
	@Override
	public int getCount(FileDto dto) {
		int count = session.selectOne("file.getCount", dto);
		
		return count;
	}
	
	@Autowired
	private SqlSession session;
}