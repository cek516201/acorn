package com.example.boot14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot14.dto.PostDto;
import com.example.boot14.repository.PostDao;

/*
 * [ service ]
 * 주로 dao객체를 주입받아서 사용한다
 * 복잡한 비즈니스 로직을 여기서 처리한다
 * 트랜잭션도 처리할 수 있다
 * 
 * */
@Service
public class PostServiceImpl implements PostService {
	@Override
	public List<PostDto> selectAll() {
		List<PostDto> list = dao.selectAll();
		
		return list;
	}

	@Override
	public PostDto insert(PostDto dto) {
		int id = dao.getSequence();
		dto.setId(id);
		
		dao.insert(dto);
		
		return dto;
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public PostDto select(int id) {
		PostDto dto = dao.select(id);
		
		return dto;
	}

	@Override
	public void update(int id, PostDto dto) {
		dto.setId(id);
		dao.update(dto);
	}
	
	@Autowired
	private PostDao dao;
}