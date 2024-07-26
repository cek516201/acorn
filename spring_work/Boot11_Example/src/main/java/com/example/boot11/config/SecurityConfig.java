package com.example.boot11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	/*
	 * 매개변수에 전달되는 HttpSecurity 객체를 이용해서 우리의 프로젝트 상황에 맞는 설정을 기반으로 만들어진
	 * SecurityFilterChain 객체를 리턴해주어야 한다. 또한 SecurityFilterChain 객체도 스프링이 관리하는 Bean
	 * 이 되어야 한다
	 */
	@Bean // 메소드에서 리턴되는 SecurityFilterChain 을 bean 으로 만들어준다.
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		String[] whiteList = { "/", "/user/loginform", "/user/login_fail", "/user/expired",
				"/user/signup_form", "/user/signup", "/error", "/upload/images/*",
				"/file/list", "/file/download", "/cafe/list", "/cafe/detail", "/editor/images/*",
				"/cafe/comment_list", "/gallery/list", "gallery/images/{imageName}", "gallery/detail"};

		httpSecurity
		.headers(header->
			// 동일한 origin에서 iframe을 사용할 수 있도록 설정
			header.frameOptions(option->option.sameOrigin()) // SmartEditor에서 필요함
		)
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(config ->
			config
				.requestMatchers(whiteList).permitAll() // 화이트리스트는 권한없이 접근 가능
				.requestMatchers("/admin/**").hasRole("ADMIN") // admin 하위경로는 어드민만 접근 가능
				.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF") // staff 하위경로는 어드민, 스태프만 접근 가능
				.anyRequest().authenticated()
		)
		.formLogin(config ->
			config
				// 인증을 거치지 않은 사용자를 리다일렉트 시킬 경로 설정
				.loginPage("/user/required_loginform")
				// 로그인 처리를 할때 요청될 url 설정 ( spring security 가 login 처리를 대신 해준다)
				.loginProcessingUrl("/user/login")
				// 로그인 처리를 대신 하려면 어떤 파라미터명으로 username 과 password 가 넘어오는지 알려주기
				.usernameParameter("userName").passwordParameter("password")
				.successHandler(new AuthSuccessHandler()) // 로그인 성공 핸들러 등록
				.failureForwardUrl("/user/login_fail").permitAll() // 위에 명시한 모든 요청경로를 로그인 없이 요청할수 있도록 설정
		)
		.logout(config ->
			config
				.logoutUrl("/user/logout")// Spring Security 가 자동으로 로그아웃 처리 해줄 경로 설정
				.logoutSuccessUrl("/")// 로그 아웃 이후에 리다일렉트 시킬 경로 설정
				.permitAll())
				.exceptionHandling(config -> config.accessDeniedPage("/user/denied")
		)
		.sessionManagement(config ->
				config
					.maximumSessions(1) // 최대 허용 세션 갯수
					.expiredUrl("/user/expired") // 허용 세션 갯수가 넘어서 로그인 해제된경우 리다이렉트 이동시킬 경로
		);

		return httpSecurity.build();
	}

	// 비밀번호를 암호화 해주는 객체를 bean으로 만든다
	@Bean
	PasswordEncoder passwordEncoder() {
		// 여기서 리턴해주는 객체도 bean으로 된다
		return new BCryptPasswordEncoder();
	}
}