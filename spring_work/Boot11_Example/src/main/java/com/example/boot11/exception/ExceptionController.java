package com.example.boot11.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 예외 컨트롤러는 @ControllerAdvice 어노테이션을 붙여서 bean으로 만든다
//@ControllerAdvice
//public class ExceptionController{
//	// 스프링 프레임워크가 동작하는 중에 PasswordException type의 예외가 발생하면 이 메소드가 자동호출 된다
//	// 매개변수에는 해당 예외객체의 참조값이 전달된다
//	// 일반 컨트롤러처럼 필요한 객체를 매개변수에 선언하면 스프링이 알아서 전달해준다
//	@ExceptionHandler(PasswordException.class)
//	public String passwordException(PasswordException pe, Model model) {
//		model.addAttribute("exception", pe);
//		
//		return "error/password";
//	}
//}

// RedirectAttribute 객체를 이용하면 리다이렉트 이동된 페이지에 데이터를 전달해줄수도 있다
@ControllerAdvice
public class ExceptionController{
	// 스프링 프레임워크가 동작하는 중에 PasswordException type의 예외가 발생하면 이 메소드가 자동호출 된다
	// 매개변수에는 해당 예외객체의 참조값이 전달된다
	// 일반 컨트롤러처럼 필요한 객체를 매개변수에 선언하면 스프링이 알아서 전달해준다
	@ExceptionHandler(PasswordException.class)
	public String passwordException(PasswordException pe, RedirectAttributes ra) {
		ra.addFlashAttribute("exception", pe); // 리다이렉트로 이동된 후 한번만 사용 가능
		
		return "redirect:/user/pwd_updateform";
	}
	
	@ExceptionHandler(NotOwnerException.class)
	public String notOwnerException(NotOwnerException noe, Model model) {
		model.addAttribute("exception", noe);
		
		return "error/info";
	}
}