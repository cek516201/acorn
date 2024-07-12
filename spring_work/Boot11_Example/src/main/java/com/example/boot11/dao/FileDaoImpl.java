package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao {
	@Override
	public List<FileDto> selectAll() {
		List<FileDto> list = session.selectList("file.selectAll");
		
		return list;
	}
	
	@Autowired
	private SqlSession session;
}