package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;

// @Responsebody의 기능이 모든 메소드에 포함된다
@RestController
public class PostController {
	@GetMapping("/posts")
	public List<PostDto> selectAll() {
		List<PostDto> list = dao.selectAll();
		
		return list;
	}
	
	@PostMapping("/posts")
	public PostDto insert(String title, String author) {
		int id = dao.getSequence();
		PostDto dto = PostDto.builder().id(id).title(title).author(author).build();
		
		dao.insert(dto);
		
		return dto;
	}
	
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable("id") int id) {
		dao.delete(id);
		
		return "{}";
	}
	
	@GetMapping("/posts/{id}")
	public PostDto select(@PathVariable("id") int id) {
		PostDto dto = dao.select(id);
		
		return dto;
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id, String title, String author) {
		PostDto dto = PostDto.builder().id(id).title(title).author(author).build();
		dao.update(dto);
		
		return dto;
	}
	
	@Autowired
	private PostDao dao;
}