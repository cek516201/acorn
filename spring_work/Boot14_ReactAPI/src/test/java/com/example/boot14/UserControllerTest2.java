package com.example.boot14;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;

import com.example.boot14.dto.UserDto;
import com.example.boot14.service.UserService;
import com.example.boot14.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest2 {
	
	// 컨트롤러를 테스트 할 수 있는 MockMvc 객체 주입받기
	@Autowired
	private MockMvc mockMvc;
	
	// UserService 객체 역할을 할 가짜 객체
	@MockBean
	private UserService userService;
	
	// Jwt 역할을 할 가짜 객체( 어떤 메소드가 호출되었을 때 어떤 동작을 하고 어떤 값을 리턴할지 정의를 해야한다)
	@MockBean
	private JwtUtil jwtUtil;
	
	// 인증을 처리할 실제 객체
	@Autowired
	private AuthenticationManager authManager;
	
	//객체의 내용을 json 문자열로 변환하기 위한 객체 (Gson 객체를 대신 사용해도 된다)
	ObjectMapper oMapper = new ObjectMapper();
	
	// 해당 클래스 안에 있는 모든 테스트를 수정하기 이전에 설정할 동작을 여기에서 준비할 수 있다
	// sample 데이터 혹은 가짜 객체의 동작 등
	@BeforeEach
	void setup() {
		// 사용 가능한 username
		String user1 = "testuser";
		// 사용 불가능한 username이라고 가정
		String user2 = "asd";
		
		Mockito.when(userService.canUse(user1)).thenReturn(true);
		Mockito.when(userService.canUse(user2)).thenReturn(false);
	}
	
	@Test
	@DisplayName("가짜 토큰 발급 테스트")
	void testAuth() throws Exception{
		// 테스트 user
		UserDto dto = UserDto.builder()
						.userName("asd")
						.password("asd!")
						.build();
		
		// 가짜객체 jwtUtil의 generateToken() 메소드가 호출되면 "mock-token"을 리턴하라는 코드
		Mockito.when(jwtUtil.generateToken(dto.getUserName())).thenReturn("mock-token");
		
		// jwt 토큰 발급을 컨트롤러가 잘 하고 있는지 테스트
		mockMvc.perform(post("/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(oMapper.writeValueAsString(dto)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").value("Bearer+mock-token"));
	}
	
	@Test
	@DisplayName("사용가능한 아이디 테스트")
	void checkUserNameSuccess() throws Exception{
		mockMvc.perform(get("/user/check_username/testuser"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.canUse", is(true)));
	}
	
	@Test
	@DisplayName("사용 불가능한 아이디 테스트")
	void checkUserNameFail() throws Exception{
		mockMvc.perform(get("/user/check_username/asd"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.canUse", is(false)));
	}
}