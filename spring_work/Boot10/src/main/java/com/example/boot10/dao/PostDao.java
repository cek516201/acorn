package com.example.boot10.dao;

import java.util.List;

import com.example.boot10.dto.PostDto;

public interface PostDao {
	public List<PostDto> selectAll();
	public int insert(PostDto dto);
	public int getId();
	public void delete(int id);
	public PostDto select(int id);
	public void update(PostDto dto);
}