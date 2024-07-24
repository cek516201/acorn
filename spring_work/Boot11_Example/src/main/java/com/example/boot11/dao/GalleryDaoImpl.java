package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.GalleryDto;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	@Override
	public void insert(GalleryDto dto) {
		session.insert("gallery.insert", dto);
	}
	
	@Override
	public List<GalleryDto> getList() {
		List<GalleryDto> list = session.selectList("gallery.getList");
		
		return list;
	}
	
	@Autowired
	private SqlSession session;
}