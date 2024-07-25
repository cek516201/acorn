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
	public List<GalleryDto> getList(GalleryDto dto) {
		List<GalleryDto> list = session.selectList("gallery.getList", dto);
		
		return list;
	}
	
	@Override
	public GalleryDto getDto(int num) {
		GalleryDto dto = session.selectOne("gallery.getDto", num);
		
		return dto;
	}
	
	@Override
	public void delete(int num) {
		session.delete("gallery.delete", num);
	}
	
	@Override
	public GalleryDto getDetail(GalleryDto dto) {
		GalleryDto detailDto = session.selectOne("gallery.getDetail", dto);
		
		return detailDto;
	}
	
	@Autowired
	private SqlSession session;
}