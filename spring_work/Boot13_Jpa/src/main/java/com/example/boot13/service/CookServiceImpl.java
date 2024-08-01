package com.example.boot13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot13.entity.Cook;
import com.example.boot13.entity.CookDto;
import com.example.boot13.repository.CookRepository;

@Service
public class CookServiceImpl implements CookService{
	@Override
	public void getList(Model model) {
		List<CookDto> list = repo.findAllByOrderByNumDesc().stream().map(CookDto::toDto).toList();

		model.addAttribute("list", list);
	}
	
	@Override
	public void insert(CookDto dto) {
		Cook c = Cook.toEntity(dto);
		
		repo.save(c);
	}
	
	@Override
	public void delete(Long num) {
		repo.deleteById(num);
	}
	
	@Autowired
	private CookRepository repo;
}