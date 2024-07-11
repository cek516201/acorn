package com.example.boot10.service;

import java.util.List;

import com.example.boot10.dto.PostDto;

public interface PostService {
	public List<PostDto> selectAll();
	public PostDto insert(String title, String author);
	public void delete(int id);
	public PostDto select(int id);
	public void update(PostDto dto);
}