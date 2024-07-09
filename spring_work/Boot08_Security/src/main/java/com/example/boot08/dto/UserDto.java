package com.example.boot08.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 모든 인자를 전달받는 생성자
@NoArgsConstructor // default 생성자
@Data
public class UserDto {
	// 숫자로된 아이디는 pk
	private int id;
	// 사용자 명은 중복데이터가 들어가지 않도록 UNIQUE KEY를 설정해야한다
	private String userName;
	private String password;
	private String email;
	// authority 정보를 저장할 칼럼 ROLE_XXX 형식
	private String role;
}