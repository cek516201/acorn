package com.example.boot11.service;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileService {
	public List<FileDto> selectAll();
}