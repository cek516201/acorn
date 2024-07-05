package com.example.boot06.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.boot06.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// 인터셉터를 레지스트리에 등록할때 호출되는 메소드를 오버라이드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInter)
				.addPathPatterns("/sub/*", "/cafe/*")
				.excludePathPatterns("/sub/play", "/cafe/list", "/cafe/detail");
	}
	
	@Autowired
	private LoginInterceptor loginInter;
}