package com.example.boot04.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot04.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {
	@GetMapping("/sub/play")
	public String play() {
		// templates/sub/play.html 해석한 결과를 응답
		return "sub/play";
	}
	
	@GetMapping("/notice")
	public String notice(Model model) {
		List<MemberDto> members = new ArrayList<MemberDto>();
		members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
		members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
		members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
		
		model.addAttribute("members", members);
		
		return "sub/notice";
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		MemberDto dto = new MemberDto(1, "ㅁㅁㅁ", "aaa");
		
		model.addAttribute("dto", dto);
		
		return "sub/member";
	}
	
	@GetMapping("/members")
	public String members(Model model) {
		List<MemberDto> members = new ArrayList<MemberDto>();
		members.add(new MemberDto(1, "ㅁㅁㅁ", "aaa"));
		members.add(new MemberDto(2, "ㄴㄴㄴ", "sss"));
		members.add(new MemberDto(3, "ㅇㅇㅇ", "ddd"));
		
		model.addAttribute("members", members);
		
		return "sub/members";
	}
	
	@GetMapping("/shop/buy")
	public String buy() {
		return "sub/buy";
	}
	
	@GetMapping("/inc")
	public String inc() {
		return "sub/inc";
	}
	
	@GetMapping("/unescape")
	public String unescape(Model model) {
		// 출력할 내용이 때로는 markup 형태일때도 있다
		String content = "<a href='https://naver.com'>naver</a>";
		model.addAttribute("content", content);
		return "sub/unescape";
	}
}