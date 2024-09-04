package com.example.boot14.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.boot14.dto.CafeDto;
import com.example.boot14.service.CafeService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CafeController {
	@PutMapping("/cafes/{num}")
	public Map<String, Object> update(@PathVariable("num") int num, @RequestBody CafeDto dto) {
		// dto에 글번호를 담고
		dto.setNum(num);
		service.updateContent(dto);

		return Map.of("isSuccess", true);
	}

	@GetMapping("/cafes/{num}/edit")
	public CafeDto edit(@PathVariable("num") int num) {
		return service.getData(num);
	}

	@DeleteMapping("/cafes/{num}")
	public Map<String, Object> delete(@PathVariable("num") int num) {
		service.deleteContent(num);

		return Map.of("isSuccess", true);
	}

	@GetMapping("/cafes/{num}")
	public Map<String, Object> detail(@PathVariable("num") int num, CafeDto dto) {
		dto.setNum(num);

		return service.getDetail(dto);
	}

	@GetMapping("/cafes")
	public Map<String, Object> list(CafeDto dto) {
		// CafeDto 객체에는 pageNum, condition, keyword가 들어있다

		return service.getList(dto);
	}

	// 클라이언트가 json 문자열을 요청 파라미터로 전달하기때문에
	// 파라미터를 추출할 때 @RequestBody가 필요
	@PostMapping("/cafes")
	public Map<String, Object> insert(@RequestBody CafeDto dto) {
		service.saveContent(dto);

		return Map.of("isSuccess", true);
	}

	@Autowired
	private CafeService service;
}