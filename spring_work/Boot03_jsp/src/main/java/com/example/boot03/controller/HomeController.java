package com.example.boot03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot03.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	// jsp페이지에게 응답에 필요한 데이터를 전달하는 방법
	// 1. HttpServletRequest 객체에 setAttribute() 메소드를 이용해서 담는다
	@GetMapping("/")
	public String home(HttpServletRequest req) {
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("ㅁㅁㅁ");
		noticeList.add("ㄴㄴㄴ");
		noticeList.add("ㅇㅇㅇ");
		
		req.setAttribute("noticeList", noticeList);
		
		return "home.jsp";
	}
	
	// 2. Model 객체에 .addAttribute() 메소드를 이용해서 담는다
	@GetMapping("/fortune")
	public String fortune(Model model) {
		String fortuneToday = "ㅁㅁㅁ";
		model.addAttribute("fortuneToday", fortuneToday);
		
		return "fortune.jsp";
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		MemberDto dto = new MemberDto(1, "ㅁㅁㅁ", "aaa");
		model.addAttribute("dto", dto);
		
		return "member.jsp";
	}
}