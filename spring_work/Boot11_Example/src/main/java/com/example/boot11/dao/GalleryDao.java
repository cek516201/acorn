package com.example.boot11.dao;

import java.util.List;

import com.example.boot11.dto.GalleryDto;

public interface GalleryDao {
	public void insert(GalleryDto dto);
	public  List<GalleryDto> getList(GalleryDto dto);
	public void delete(int num);
	public GalleryDto getData(GalleryDto dto);
	public int getCount(GalleryDto dto);
}