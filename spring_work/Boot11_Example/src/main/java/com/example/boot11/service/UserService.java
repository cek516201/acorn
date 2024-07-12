package com.example.boot11.service;

import com.example.boot11.dto.UserDto;

public interface UserService {
	public UserDto getInfo();
	public void addUser(UserDto dto);
	public void updatePwd(UserDto dto);
	public void update(UserDto dto);
}