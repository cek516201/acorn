package com.example.boot01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컴포넌트 스캔이 일어나는 위치에 클래스가 존재해야한다
// 적절한 어노테이션이 클래스에 붙어있어야한다
@Component
public class HomeServiceImpl implements HomeService{
	@Override
	public void clean(String name) {
		System.out.println("clean " + name);
	}

	@Override
	public void wash(String name) {
		System.out.println("wash " + name);
	}

	@Override
	public void hole(String name) {
		System.out.println("hole " + name);
		drill.hole();
	}
	
	// 객체가 자동주입됨
	@Autowired
	private Drill drill;
}