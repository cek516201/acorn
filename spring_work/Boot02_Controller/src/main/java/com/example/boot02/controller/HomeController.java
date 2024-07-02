package com.example.boot02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot02.dto.MemberDto;

// 클라이언트의 요청을 처리할 컨트롤러를 정의하고 bean으로 만들기
@Controller
public class HomeController {
	@ResponseBody
	@GetMapping("/hello") // 클라이언트가 "/hello" 경로로 요청을 하면 이 메소드가 실행된다
	public String hello() {
		// string type을 리턴하면서 메소드에 @ResponseBody 어노테이션을 붙여놓으면
		// 여기서 리턴한 문자열이 클라이언트에게 그대로 출력된다
		return "hello";
	}
	
	@ResponseBody
	@GetMapping("/fortune")
	public String fortune() {
		return "fortune";
	}
	
	@ResponseBody // @ResponseBody 어노테이션이 붙어있는 메소드에서 Map 객체를 리턴하면 json 문자열로 변환되어서 응답된다
	@GetMapping("/member")
	public Map<String, Object> member(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "ㅁㅁㅁ");
		map.put("isMan", true);
		
		return map;
	}
	
	@ResponseBody // @ResponseBody 어노테이션이 붙어있는 메소드에서 Dto 객체를 리턴하면 json 문자열로 변환되어서 응답된다
	@GetMapping("/member2")
	public MemberDto member2(){
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("ㅁㅁㅁ");
		dto.setAddr("aaa");
		
		return dto;
	}
	
	@ResponseBody // @ResponseBody 어노테이션이 붙어있는 메소드에서 List 객체를 리턴하면 배열로 변환되어서 응답된다
	@GetMapping("/friends") 
	public List<String> friends(){
		List<String> names = new ArrayList<String>();
		names.add("ㅁㅁㅁ");
		names.add("ㄴㄴㄴ");
		names.add("ㅇㅇㅇ");
		
		return names;
	}
	
	@ResponseBody
	@GetMapping("/members") 
	public List<MemberDto> members(){
		List<MemberDto> members = new ArrayList<MemberDto>();
		members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
		members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
		members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
		
		return members;
	}
}