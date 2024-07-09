package com.example.boot10.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;

@Controller
public class HomeController {
	@ResponseBody
	@GetMapping("/posts")
	public String selectAll() {
		List<PostDto> postList = dao.selectAll();
		
		return "selectAll";
	}
	
	@ResponseBody
	@PostMapping("/posts")
	public String insert(@RequestParam ) {
		dao.insert(null);
		
		return "insert";
	}
	
	@ResponseBody
	@GetMapping("/posts/{id}")
	public String select(@PathVariable int id) {
		return "select " + id;
	}
	
	@ResponseBody
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable int id) {
		return "delete " + id;
	}
	
	@ResponseBody
	@PutMapping("/posts/{id}")
	public String update(@PathVariable int id) {
		return "update " + id;
	}
	
	@Autowired
	private PostDao dao;
}