package com.example.boot11.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.example.boot11.dto.FileDto;

public interface FileService {
	public List<FileDto> getList(Model model);
	public void delete(int num);
	public void insert(FileDto dto);
	public ResponseEntity<InputStreamResource> download(int num);
}