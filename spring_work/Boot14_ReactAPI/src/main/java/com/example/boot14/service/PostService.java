package com.example.boot14.service;

import java.util.List;

import com.example.boot14.dto.PostDto;

public interface PostService {
	public List<PostDto> selectAll();
	public PostDto insert(PostDto dto);
	public void delete(int id);
	public PostDto select(int id);
	public void update(int id, PostDto dto);
}