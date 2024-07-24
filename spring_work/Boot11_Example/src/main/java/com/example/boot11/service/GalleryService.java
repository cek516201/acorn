package com.example.boot11.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;

public interface GalleryService {
	void upload(MultipartFile file, String caption);
	List<GalleryDto> getList();
	byte[] images(String name) throws FileNotFoundException, IOException;
	void delete(int num);
}