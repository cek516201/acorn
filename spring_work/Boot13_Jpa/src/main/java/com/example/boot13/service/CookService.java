package com.example.boot13.service;

import org.springframework.ui.Model;

import com.example.boot13.entity.CookDto;

public interface CookService {
	public void getList(Model model);
	public void insert(CookDto dto);
	public void delete(Long num);
}