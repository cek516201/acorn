package com.example.boot11.dao;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileDao {
	public List<FileDto> selectAll();
}