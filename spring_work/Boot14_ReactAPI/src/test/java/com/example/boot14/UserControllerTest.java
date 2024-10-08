package com.example.boot14;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot14.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// 객체(dto 등)에 저장된 내용을 json 문자열로 변경해주는 기능을 가지고 있는 객체
	ObjectMapper oMapper = new ObjectMapper();

	@Test
	void authTest() throws Exception {
        UserDto dto = UserDto.builder()
            .userName("asd")
            .password("asd!")
            .build();

    	mockMvc.perform(post("/auth")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(oMapper.writeValueAsString(dto)))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$").isNotEmpty())
    		.andDo(result -> {
    			String jwt = result.getResponse().getContentAsString();
    			//문자열이 Bearer 로 시작되는지 확인
    			assertTrue(jwt.startsWith("Bearer"));
    			System.out.println(jwt);
    		});
	}

    @Test
	void authFailTest() throws Exception {
        UserDto dto = UserDto.builder()
            .userName("aaa")
            .password("sss")
            .build();

		mockMvc.perform(post("/auth")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(oMapper.writeValueAsString(dto)))
				.andDo(print())
	        .andExpect(status().is4xxClientError());
	}

    // 아이디 사용가능 여부 테스트 (존재하는 아이디 => false, 존재하지 않는 아이디 => true)
    @Test
    void checkUserNameTest() throws Exception {
    	// 사용 불가능한 아이디
    	String userName1 = "asd";    	
        mockMvc.perform(get("/user/check_username/" + userName1))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.canUse", is(false)));
        
        // 사용 가능한 아이디
    	String userName2 = UUID.randomUUID().toString();    	
        mockMvc.perform(get("/user/check_username/" + userName2))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.canUse", is(true)));
    }

	@WithUserDetails("asd") // 실제 존재하는 테스트 아이디를 이용한다
	@Test
	void userInfoTest() throws Exception {
		// get 방식의 /user 요청을 하기 위해서는 token이 있어야하는데 어떻게해야하나
		String result = mockMvc.perform(get("/user"))
			.andExpect(status().isOk())
			.andDo(print())
			.andReturn()
			.getResponse()
			.getContentAsString();

		System.out.println(result);

		String userName = JsonPath.read(result, "$.userName");
		assertEquals(userName, "asd");
	}

	// 회원가입 테스트
	@Transactional
	@Test
	void testAddUser() throws Exception {
		// 회원가입 정보를 UserDto에 담는다
		UserDto dto = UserDto.builder()
			.userName("testUser")
			.password("testpwd")
			.email("testemail@")
			.build();

		// 회원가입 요청을 보낸다
		mockMvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(oMapper.writeValueAsString(dto)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.isSuccess", is(true)));
	}

	// 회원정보 수정 테스트
	@Transactional
	@WithUserDetails("asd") // 실제 존재하는 테스트 아이디를 이용한다
	@Test
	void testUpdateUser() throws Exception {
		// 회원정보 수정 요청을 보낸다
		mockMvc.perform(patch("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.param("userName", "asd")
				.param("email", "testemail@"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.isSuccess", is(true)));
	}
}