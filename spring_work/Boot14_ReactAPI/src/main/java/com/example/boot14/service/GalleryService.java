package com.example.boot14.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface GalleryService {
	public Map<String, Object> selectPage(int pageNum);
}