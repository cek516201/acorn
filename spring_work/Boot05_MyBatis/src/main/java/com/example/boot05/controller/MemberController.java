package com.example.boot05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot05.dao.MemberDao;
import com.example.boot05.dto.MemberDto;

@Controller
public class MemberController {
	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list", list);
		
		return "member/list";
	}
	
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	@PostMapping("/member/insert")
	public String insert(MemberDto dto) {
		dao.insert(dto);
		
		return "member/insert";
	}
	
	@GetMapping("/member/delete")
	public String delete(int num) {
		dao.delete(num);
		
		// 리다이렉트
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/updateform")
	public String updateform(int num, Model model) {
		MemberDto dto = dao.select(num);
		model.addAttribute("dto", dto);
		
		return "member/updateform";
	}
	@PostMapping("/member/update")
	public String update(MemberDto dto) {
		dao.update(dto);
		
		return "member/update";
	}
	
	@Autowired
	private MemberDao dao;
}