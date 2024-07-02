package com.example.boot01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	@Autowired
	private Drill drill;
}