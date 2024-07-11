package com.example.boot11.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	@Override
	public UserDto select(String userName) {
		UserDto dto = session.selectOne("user.select", userName);
		
		return dto;
	}
	
	@Override
	public void insert(UserDto dto) {
		session.insert("user.insert", dto);
	}

	@Override
	public void update(UserDto dto) {
		session.update("user.update", dto);
	}
	
	@Autowired
	private SqlSession session;
}