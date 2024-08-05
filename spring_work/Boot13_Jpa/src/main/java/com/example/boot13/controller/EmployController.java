package com.example.boot13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot13.entity.Dept;
import com.example.boot13.entity.DeptDto;
import com.example.boot13.entity.EmpDeptDto;
import com.example.boot13.repository.DeptRepository;
import com.example.boot13.repository.EmpRepository;

@Controller
public class EmployController {
	@GetMapping("/emp/dept_detail")
	public String dept_detail(int deptno, Model model) {
		 Dept dept = deptRepo.findById(deptno).get();
		 DeptDto dto = DeptDto.toDto(dept);
		 
		 model.addAttribute("dto", dto);
		
		return "emp/dept_detail";
	}
	
	@GetMapping("/emp/list")
	public String list(Model model) {
		List<EmpDeptDto> list = empRepo.findAll().stream().map(EmpDeptDto::toDto).toList();
		model.addAttribute("list", list);
		
		return "emp/list";
	}
	
	@Autowired
	private EmpRepository empRepo;
	@Autowired
	private DeptRepository deptRepo;
}