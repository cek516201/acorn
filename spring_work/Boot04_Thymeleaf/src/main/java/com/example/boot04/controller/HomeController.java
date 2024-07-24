package com.example.boot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("personToday","ㅁㅁㅁ"); // 자동으로 HttpServletRequest에 담긴다
		
		model.addAttribute("id", 99);
		model.addAttribute("count", 3);
		
		return "home"; // 여기서 리턴한 문자열 앞에는 /templates/ 가 붙고 뒤에는 .html이 붙는다
	}
}