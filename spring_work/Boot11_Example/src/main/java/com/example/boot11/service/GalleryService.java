package com.example.boot11.service;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;

public interface GalleryService {
	void upload(MultipartFile file, String caption);
	void getList(Model model, GalleryDto dto);
	byte[] images(String name) throws IOException;
	void delete(int num);
	void getData(Model model, GalleryDto dto);
}