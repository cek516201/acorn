package com.example.boot10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot10.dto.PostDto;

@Repository
public class PostDaoImpl implements PostDao {
	@Override
	public List<PostDto> selectAll() {
		List<PostDto> list = session.selectList("post.selectAll");
		
		return list;
	}

	@Override
	public int insert(PostDto dto) {
		int id = session.insert("post.insert", dto);
		
		return id;
	}
	@Override
	public int getId() {
		int id = session.selectOne("post.getId");
		
		return id;
	}

	@Override
	public void delete(int id) {
		session.delete("post.delete", id);
	}

	@Override
	public PostDto select(int id) {
		PostDto dto = session.selectOne("post.select", id);
		
		return dto;
	}

	@Override
	public void update(PostDto dto) {
		session.update("post.update", dto);
	}

	@Autowired
	private SqlSession session;
}