package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;

@Controller
public class HomeController {
	@ResponseBody
	@GetMapping("/posts")
	public List<PostDto> selectAll() {
		List<PostDto> list = dao.selectAll();
		
		return list;
	}
	
	@ResponseBody
	@PostMapping("/posts")
	public PostDto insert(PostDto dto) {
		int id = dao.getId();
		dto.setId(id);
		
		dao.insert(dto);
		
		return dto;
	}
	
	@ResponseBody
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable int id) {
		dao.delete(id);
		
		return "{}";
	}
	
	@ResponseBody
	@GetMapping("/posts/{id}")
	public PostDto select(@PathVariable int id) {
		PostDto dto = dao.select(id);
		
		return dto;
	}
	
	@ResponseBody
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable int id, PostDto dto) {
		dto.setId(id);
		dao.update(dto);
		
		return dto;
	}
	
	@Autowired
	private PostDao dao;
}