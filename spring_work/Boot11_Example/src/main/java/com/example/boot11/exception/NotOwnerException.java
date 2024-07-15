package com.example.boot11.exception;

public class NotOwnerException extends RuntimeException{
	public NotOwnerException(String message) {
		super(message); // 생성자에 전달되는 예외메시지를 부모생성자에 넘겨준다
		// 부모생성자에 넘겨준 예외 메시지는 이 객체의 .getMessage() 메소드를 호출하면 리턴한다
	}
}