package com.example.boot11.dao;

import java.util.List;

import com.example.boot11.dto.GalleryDto;

public interface GalleryDao {
	void insert(GalleryDto dto);
	List<GalleryDto> getList(GalleryDto dto);
	GalleryDto getDto(int num);
	void delete(int num);
	GalleryDto getDetail(GalleryDto dto);
}