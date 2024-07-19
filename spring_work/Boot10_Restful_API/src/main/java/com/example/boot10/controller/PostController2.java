package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dto.PostDto;
import com.example.boot10.service.PostService;

// @Responsebody의 기능이 모든 메소드에 포함된다
@RestController
@RequestMapping("/v2")
public class PostController2 {
	@GetMapping("/posts")
	public List<PostDto> selectAll() {
		List<PostDto> list = service.selectAll();
		
		return list;
	}
	
	// 요청의 body에 json문자열이 전송되면 요청 파라미터를 추출하는 방법이 다르다
	// @RequestBody 어노테이션을 붙여주면 된다
	// 그러면 json 문자열의 key와 dto의 필드값이 일치하면 데이터가 추출되어서 필드에 저장된다
	@PostMapping("/posts")
	public PostDto insert(@RequestBody PostDto dto) {
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
	public PostDto update(@PathVariable("id") int id, @RequestBody PostDto dto) {
		service.update(id, dto);
		
		return dto;
	}
	
	@Autowired
	private PostService service;
}