package com.example.boot11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot11.dto.UserDto;
import com.example.boot11.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public void getInfo(Model model) {
		// 개인정보를 보려면 로그인을 한 상태인데 userName을 얻어내려면
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDto dto = dao.select(userName);
		model.addAttribute("dto", dto);
	}
	
	@Override
	public void addUser(UserDto dto) {
		dto.setRole("USER");
		
		// 비밀번호 암호화
		dto.setPassword(encoder.encode(dto.getPassword()));
		
		dao.insert(dto);
	}
	
	@Override
	public void updateUser(UserDto dto) {
		
	}

	@Override
	public void updatePassword(UserDto dto) {
		// 로그인된 userName을 읽어낸다
		
		// 기존의 비밀번호를 DB에서 읽어와서
		
		// 입력한(구 비밀번호)와 일치하는지 비교해서
		
		// 만일 일치하지 않으면 Exception을 발생시킨다
		
		// 일치하면 새 비밀번호를 암호화해서 dto에 담은 다음
		
		// userName도 dto에 담고
		
		// DB에 비밀번호 수정반영을 한다
		
	}
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserDao dao;
}