package com.example.boot11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.CafeDto;
import com.example.boot11.dto.GalleryDto;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	@Override
	public void insert(GalleryDto dto) {
		session.insert("gallery.insert", dto);
	}
	
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		List<GalleryDto> list = session.selectList("gallery.getList", dto);
		
		return list;
	}
	
	@Override
	public void delete(int num) {
		session.delete("gallery.delete", num);
	}
	
	@Override
	public GalleryDto getData(GalleryDto dto) {
		GalleryDto data = session.selectOne("gallery.getData", dto);
		
		return data;
	}
	
	@Override
	public int getCount(GalleryDto dto) {
		int count = session.selectOne("gallery.getCount", dto);
		
		return count;
	}
	
	@Autowired
	private SqlSession session;
}