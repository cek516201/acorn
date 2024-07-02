package com.example.boot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}