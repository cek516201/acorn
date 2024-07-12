package com.example.boot11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot11.dao.FileDao;
import com.example.boot11.dao.UserDao;
import com.example.boot11.dto.FileDto;

@Service
public class FileServiceImpl implements FileService {
	@Override
	public List<FileDto> selectAll() {
		List<FileDto> list = dao.selectAll();
		
		return list;
	}
	
	@Autowired
	private FileDao dao;
}