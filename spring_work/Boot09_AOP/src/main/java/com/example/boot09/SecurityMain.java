package com.example.boot09;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityMain {
	public static void main(String[] args) {
		String pwd = "1234";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(pwd);
		System.out.println("인코딩된 비밀번호 : " + encodedPwd);
		
		System.out.print("비밀번호 입력 : ");
		String inputPwd = new Scanner(System.in).nextLine();
		boolean isValid = BCrypt.checkpw(inputPwd, encodedPwd);
		System.out.println(isValid);
	}
}