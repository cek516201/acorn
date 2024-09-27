package com.example.boot14.exception;

public class PasswordException extends RuntimeException {
	// 생성자로 전달되는 예외를 부모 생성자에 전달
	public PasswordException(String msg) {
		super(msg);
	}
}