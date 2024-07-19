package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dto.PostDto;
import com.example.boot10.service.PostService;

// @Responsebody의 기능이 모든 메소드에 포함된다
@RestController
@RequestMapping("/v1")
public class PostController1 {
	@GetMapping("/posts")
	public List<PostDto> selectAll() {
		List<PostDto> list = service.selectAll();
		
		return list;
	}
	
	@PostMapping("/posts")
	public PostDto insert(PostDto dto) {
		PostDto postDto = service.insert(dto);

		return postDto;
	}
	
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		
		return "{}";
	}
	
	@GetMapping("/posts/{id}")
	public PostDto select(@PathVariable("id") int id) {
		PostDto dto = service.select(id);
		
		return dto;
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id, PostDto dto) {
		service.update(id, dto);
		
		return dto;
	}
	
	@Autowired
	private PostService service;
}