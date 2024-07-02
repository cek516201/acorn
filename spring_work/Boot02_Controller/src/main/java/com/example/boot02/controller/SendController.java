package com.example.boot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot02.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SendController {
	// 컨트롤러 메소드 안에서 request, response, session 등의 객체가 필요하면 매개변수에 선언하면 된다
	// 선언만 하면 알아서 참조값을 매개변수에 전달해준다
	@ResponseBody
	@PostMapping("/send")
	public String send(HttpServletRequest req) {
		return req.getParameter("msg");
	}

	// 전송되는 파라미터명과 동일하게 매개변수를 설정하면 자동으로 추출되어서 매개변수에 전달된다
	@ResponseBody
	@PostMapping("/send2")
	public String send2(String msg) {
		return msg;
	}

	@ResponseBody
	@PostMapping("/send3")
	public String send3(@RequestParam(defaultValue = "0") int num, @RequestParam(defaultValue = "ㅁㅁㅁ") String name) {
		return num + " " + name;
	}

	// 전송되는 파라미터명과 동일한 필드명을 가지고 있는 Dto type으로 매개변수를 선언하면
	// Dto 객체가 자동으로 생성되고 생성된 객체에 전송된 파라미터 값이 담은 다음 그 참조값을 매개변수에 전달해준다
	@ResponseBody
	@PostMapping("/send4")
	public String send4(MemberDto dto) {
		return dto.getNum() + " " + dto.getName();
	}
}