package com.example.boot10.dao;

import java.util.List;

import com.example.boot10.dto.PostDto;

public interface PostDao {
	public List<PostDto> selectAll();
	public void insert(PostDto dto);
	public void delete(int num);
	public PostDto select(int num);
	public void update(PostDto dto);
}