package com.example.boot14.repository;

import java.util.List;

import com.example.boot14.dto.PostDto;

public interface PostDao {
	public List<PostDto> selectAll();
	public void insert(PostDto dto);
	public int getSequence();
	public void delete(int id);
	public PostDto select(int id);
	public void update(PostDto dto);
}