package com.example.boot14.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.boot14.dto.MemberDto;
import com.example.boot14.service.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MemberController {
	@GetMapping("/members")
	public List<MemberDto> members() {
		List<MemberDto> list = service.selectList();
		
		return list;
	}
	
	/*
	 *  axios.post("/members/", object type)  로 전송 했기 때문에 
	 *  request 의 body 에는 json 문자열이 들어 있다
	 *  json 문자열을 java 객체로 받기 위해서는 
	 *  @RequestBody 어노테이션이 필요하다 
	 *  
	 *  {"name":"입력한이름", "addr":"입력한주소"} 
	 *  
	 *  입력한 이름은 MemberDto 의 name 이라는 필드에 
	 *  입력한 주소는 MemberDto 의 addr 이라는 필더에 자동으로 담긴다 
	 */
	// json -> MemberDto
	@PostMapping("/members")
	public MemberDto insert(@RequestBody MemberDto dto) {
		// MemberDto -> json
		return service.addMember(dto);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num") int num) {
		service.deleteMember(num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		
		return map;
	}
	
	@GetMapping("/members/{num}")
	public MemberDto getData(@PathVariable("num") int num) {
		return service.selectOne(num);
	}
	
	@PutMapping("/members/{num}")
	public MemberDto update(@RequestBody MemberDto dto) {
		service.updateMember(dto);
		
		return dto;
	}
	
	@Autowired
	private MemberService service;
}