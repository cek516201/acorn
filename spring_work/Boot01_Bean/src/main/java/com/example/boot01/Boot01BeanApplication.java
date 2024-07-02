package com.example.boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.boot01.service.HomeService;

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