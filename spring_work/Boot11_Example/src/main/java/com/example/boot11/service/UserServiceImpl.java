package com.example.boot11.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dao.UserDao;
import com.example.boot11.dto.UserDto;
import com.example.boot11.exception.PasswordException;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public UserDto getInfo() {
		// 개인정보를 보려면 로그인을 한 상태인데 userName을 얻어내려면
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDto dto = dao.select(userName);
		
		return dto;
	}
	
	@Override
	public void addUser(UserDto dto) {
		dto.setRole("USER");
		
		// 비밀번호 암호화
		dto.setPassword(encoder.encode(dto.getPassword()));
		
		dao.insert(dto);
	}

	@Override
	public void updatePwd(UserDto dto) {
		// 로그인된 userName을 읽어낸다
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		// 기존의 비밀번호를 DB에서 읽어와서
		String encodedPwd = dao.select(userName).getPassword();
		// 입력한(구 비밀번호)와 일치하는지 비교해서
		boolean isValid = BCrypt.checkpw(dto.getPassword(), encodedPwd);
		// 만일 일치하지 않으면 Exception을 발생시킨다
		if(!isValid) {
			throw new PasswordException("비밀번호가 일치하지 않습니다");
		}
		// 일치하면 새 비밀번호를 암호화해서 dto에 담은 다음
		dto.setNewPassword(encoder.encode(dto.getNewPassword()));
		// userName도 dto에 담고
		dto.setUserName(userName);
		// DB에 비밀번호 수정반영을 한다
		dao.updatePwd(dto);
	}
	
	@Override
	public void update(UserDto dto) {
		MultipartFile image = dto.getImage();
		if(image.getSize() != 0) {// 선택한 프로필 이미지가 있으면
			// 파일을 원하는 위치로 이동시켜놓고
			String saveFileName = UUID.randomUUID().toString();
			// 저장할 파일의 전체 경로 구성하기
			String filePath = fileLocation + File.separator + saveFileName;
			try {
				// 업로드된 파일을 이동시킬 목적지 File 객체
				File f = new File(filePath);
				// MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
				dto.getImage().transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// UserDto에 저장된 이미지의 이름을 넣어준다
			dto.setProfile(saveFileName);
		}
		// 로그인된 userName도 dto에 담아준다
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		dto.setUserName(userName);
		
		// 수정반영
		dao.update(dto);
	}
	
	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder encoder;
	@Value("${file.location}")
	private String fileLocation;
}