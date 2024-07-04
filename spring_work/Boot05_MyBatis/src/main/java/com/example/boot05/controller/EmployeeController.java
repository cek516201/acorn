package com.example.boot05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot05.dao.EmployeeDao;
import com.example.boot05.dto.EmployeeDto;

@Controller
public class EmployeeController {
	@GetMapping("/employee/list")
	public String list(Model model) {
		List<EmployeeDto> list = dao.getList();
		model.addAttribute("list", list);
		
		return "employee/list";
	}
	
	@Autowired
	private EmployeeDao dao;
}