package com.example.boot11.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.boot11.dto.CafeCommentDto;
import com.example.boot11.dto.CafeDto;
import com.example.boot11.service.CafeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CafeController {
	@GetMapping("/cafe/detail")
	public String detail(Model model, CafeDto dto) {
		service.getDetail(model, dto);
		
		return "cafe/detail";
	}
	
	@PostMapping("/cafe/insert")
	public String insert(CafeDto dto) {
		service.saveContent(dto);
		
		return "cafe/insert";
	}
	
	@GetMapping("/cafe/insertform")
	public String insertform() {
		return "cafe/insertform";
	}
	
	@GetMapping("/cafe/list")
	public String list(Model model, CafeDto dto) {
		service.getList(model, dto);
		
		return "cafe/list";
	}
	
	@GetMapping("/cafe/updateform")
	public String updateform(Model model, int num) {
		service.getData(model, num);
		
		return "cafe/updateform";
	}
	
	@PostMapping("/cafe/update")
	public String update(CafeDto dto) {
		service.updateContent(dto);
		
		return "redirect:/cafe/list";
	}
	
	@GetMapping("/cafe/delete")
	public String delete(int num) {
		service.deleteContent(num);
		
		return "redirect:/cafe/list";
	}
	
	// ref_group, target_id, content의 정보가 들어있다(대댓글의 경우에는 comment_group 번호도 들어있다)
	@PostMapping("/cafe/comment_insert")
	public String commentInsert(CafeCommentDto dto) {
		service.saveComment(dto);
		
		return "redirect:/cafe/detail?num=" + dto.getRef_group();
	}
	
	@ResponseBody
	@GetMapping("/cafe/comment_delete")
	public Map<String, Object> commentDelete(int num){
		service.deleteComment(num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		
		return map;
	}
	
	@ResponseBody
	@PostMapping("/cafe/comment_update")
	public Map<String, Object> commentUpdate(CafeCommentDto dto){
		service.updateComment(dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		map.put("num", dto.getNum());
		map.put("content", dto.getContent());
		
		return map;
	}
	
	@GetMapping("/cafe/comment_list")
	public String commentList(Model model, CafeCommentDto dto) {
		// CafeCommentDto에는 pageNum, ref_group이 들어있다(GET 방식 파라미터)
		service.getCommentList(model, dto);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "cafe/comment_list";
	}
	
	
	@Autowired
	private CafeService service;
}