package com.example.boot11.dao;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileDao {
	public List<FileDto> getList();
	public void delete(int num);
	public void insert(FileDto dto);
	public FileDto select(int num);
	public int getCount(); // 글의 전체 갯수
}