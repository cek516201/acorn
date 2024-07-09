package com.example.boot08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	@GetMapping("/user/loginform")
	public String loginform() {
		// templates/user/loginform.html 페이지로 forward 이동해서 응답 
		return "user/loginform";
	}
	
	// 로그인이 필요한 요청경로를 로그인 하지 않은 상태로 요청하면 리다이렉트 되는 요청경로 
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}
	// POST 방식 /user/login 요청후 로그인 성공인경우 forward 이동될 url 
	@PostMapping("/user/login_success")
	public String loginSuccess() {
		return "user/login_success";
	}
	
	// 로그인 폼을 제출(post) 한 로그인 프로세스 중에 forward 되는 경로이기 때문에 @PostMapping 임에 주의!
	@PostMapping("/user/login_fail")
	public String loginFail() {
		//로그인 실패임을 알릴 페이지
		return "user/login_fail";
	}
	
	// ROLL_STAFF, ROLL_ADMIN만 요청 가능
	@GetMapping("/staff/user/list")
	public String userList() {
		return "user/list";
	}
	// ROLL_ADMIN만 요청 가능
	@GetMapping("/admin/user/manage")
	public String userManage() {
		return "user/manage";
	}
	
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
}