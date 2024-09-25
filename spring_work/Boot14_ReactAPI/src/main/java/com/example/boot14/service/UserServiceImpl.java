package com.example.boot14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.boot14.dto.UserDto;
import com.example.boot14.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void addUser(UserDto dto) {
		// role은 일반 User로 넣어준다
		dto.setRole("USER");
		// 비밀번호 암호화해서 dto에 다시 넣기
		String encodedPwd = encoder.encode(dto.getPassword());
		dto.setPassword(encodedPwd);

		dao.insert(dto);
	}

	@Override
	public UserDto getInfo() {
		//개인 정보를 본다는 것은 이미 로그인을 한 상태인데 로그인된 userName 은 어떻게 얻어내지???
		//Spring Security 의 기능을 통해서 얻어낸다 
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();	
		
		return dao.getData(userName);
	}

	@Override
	public void updateUser(UserDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(UserDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUse(String userName) {
		UserDto dto = dao.getData(userName); // 없으면 null
		// 사용 가능한지 여부
		boolean canUse = dto == null;
		return canUse;
	}
}