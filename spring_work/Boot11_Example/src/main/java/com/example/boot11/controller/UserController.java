package com.example.boot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.boot11.dto.UserDto;
import com.example.boot11.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	// 권한 부족 시 or 403인 경우
	@RequestMapping("/user/denied") // GET, POST 등 모두 가능
	public String userDenied() {
		return "user/denied";
	}

	// 세션 허용갯수 초과시
	@GetMapping("/user/expired")
	public String userExpired() {
		return "user/expired";
	}
	
	@GetMapping("/user/info")
	public String info(Model model) {
		service.getInfo(model);
		
		return "user/info";
	}
	
	// 로그인 폼을 제출(post) 한 로그인 프로세스 중에 forward 되는 경로이기 때문에 @PostMapping 임에 주의!
	@PostMapping("/user/login_fail")
	public String loginFail() {
		//로그인 실패임을 알릴 페이지
		return "user/login_fail";
	}
	
	// POST 방식 /user/login 요청후 로그인 성공인경우 forward 이동될 url 
	@PostMapping("/user/login_success")
	public String loginSuccess() {
		return "user/login_success";
	}
	
	@GetMapping("/user/loginform")
	public String loginform() {
		// templates/user/loginform.html 페이지로 forward 이동해서 응답 
		return "user/loginform";
	}
	
	@GetMapping("/user/pwd_update")
	public String pwdUpdate(UserDto dto, HttpSession session) {
		service.updatePassword(dto);
		session.invalidate();
		
		return "user/pwd_update";
	}
	
	@GetMapping("/user/pwd_updateform")
	public String pwdUpdateform() {
		return "user/pwd_updateform";
	}
	
	// 로그인이 필요한 요청경로를 로그인 하지 않은 상태로 요청하면 리다이렉트 되는 요청경로 
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}
	
	@GetMapping("/user/signup_form")
	public String signupForm() {
		return "user/signup_form";
	}
	
	@PostMapping("/user/signup")
	public String signup(UserDto dto) {
		service.addUser(dto);
		
		return "user/signup";
	}
	
	@Autowired
	private UserService service;
}