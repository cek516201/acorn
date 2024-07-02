package com.example.boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.boot01.service.HomeService;

// 이 클래스가 존재하는 패키지 또는 하위 패키지를 모두 스캔해서
// 스프링이 관리할 객체를 생성하도록 한다
@SpringBootApplication
public class Boot01BeanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Boot01BeanApplication.class, args);
		
		HomeService service = ctx.getBean(HomeService.class);
		service.clean("ㅁㅁㅁ");
		service.wash("ㄴㄴㄴ");
		service.hole("ㅇㅇㅇ");
	}
}