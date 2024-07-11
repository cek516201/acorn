package com.example.boot11.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model m) {
		List<String> notice = Arrays.asList("ㅁㅁㅁ","ㄴㄴㄴ","ㅇㅇㅇ");
		m.addAttribute("notice", notice);
		
		return "home";
	}
}