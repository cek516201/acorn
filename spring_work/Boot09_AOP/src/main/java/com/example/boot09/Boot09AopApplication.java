package com.example.boot09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.boot09.util.Messenger;
import com.example.boot09.util.WritingUtil;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Boot09AopApplication {
	public static void main(String[] args) {
		// 내부적으로 Boot09AopApplication 객체가 생성된다 (Spring Bean Container도 만들어진다)
		SpringApplication.run(Boot09AopApplication.class, args);
	}
	
	// 이 클래스 객체가 성공적으로 생성된 이후에 호출되는 메소드
	@PostConstruct
	public void test() {
		util.writeLetter();
		util.writeReport();
		util.writeDiary();
		messenger.sendGreeting("안녕하세요");
		messenger.sendGreeting("안녕하세요 똥깨님");
		System.out.println("받은 메시지 : " + messenger.getMessage()); 
	}
	
	@Autowired WritingUtil util;
	@Autowired Messenger messenger;
}