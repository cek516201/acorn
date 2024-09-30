package com.example.boot14;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot14.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class MemberControllerTest {
	// 컨트롤러에 요청을 하고 결과를 확인해 볼 수 있는 객체
	@Autowired
	private MockMvc mockMvc;
	// 객체에 있는 정보를 이용해서 json 문자열을 만들어 주는 객체
	private ObjectMapper oMapper = new ObjectMapper();

	@Test
	void testInsert() throws Exception {
		// insert할 회원 정보
		MemberDto dto = MemberDto.builder().name("test_name").addr("test_addr").build();

		// dto에 있는 정보를 이용해서 json 문자열 얻어내기
		String json = oMapper.writeValueAsString(dto);

		// post("/members") => post 방식 /members 요청
		// .contentType(MediaType.APPLICATION_JSON) => json 문자열을 전송하겠다는 요청 header 정보
		// .content(전송할 문자열 json)
		// .andExpect() => 결과 응답으로 기대하는 내용
		// .andExpect(status().isOk()) => 200번 정상응답
		// .andExpect(jsonPath("$.name", is("test_name"))) => 응답된 json 문자열에서 name이라는 키값으로 저장된 값이 "test_name" 인지
		// .andExpect(jsonPath("$.addr", is("test_addr"))) => 응답된 json 문자열에서 addr이라는 키값으로 저장된 값이 "test_addr" 인지
		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("test_name")))
				.andExpect(jsonPath("$.addr", is("test_addr")));
	}
}