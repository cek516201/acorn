package com.example.boot14.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot14.service.GalleryService;

@RestController
public class GalleryController {
	@GetMapping("/gallery")
	public Map<String, Object> getList(@RequestParam int pageNum){
		return service.selectPage(pageNum);
	}
	
	@Autowired
	private GalleryService service;
}