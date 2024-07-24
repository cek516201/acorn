package com.example.boot06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}
	@PostMapping("/user/login")
	public String login(String id, String pwd, HttpSession session) {
		session.setAttribute("id", id);
		
		return "redirect:/";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}