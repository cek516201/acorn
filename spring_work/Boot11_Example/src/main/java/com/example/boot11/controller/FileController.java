package com.example.boot11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;
import com.example.boot11.service.FileService;

@Controller
public class FileController {
	@GetMapping("/file/list")
	public String list(Model model) {
		List<FileDto> list = service.getList(model);
		
		return "file/list";
	}
	
	@ResponseBody
	@GetMapping("/file/download")
	public ResponseEntity<InputStreamResource> download(int num){
		ResponseEntity<InputStreamResource> responseEn = service.download(num);
		
		//리턴해주면 자동으로 다운로드가 된다. 
		return responseEn;
	}
	
	@GetMapping("/file/delete")
	public String delete(int num) {
		service.delete(num);
		
		return "redirect:/file/list";
	}
	
	@GetMapping("/file/upload_form")
	public String upload_form() {
		return "file/upload_form";
	}
	
	@PostMapping("/file/upload")
	public String upload(String title, MultipartFile file) {
		FileDto dto = FileDto.builder().title(title).file(file).build();
		service.insert(dto);
		
		return "redirect:/file/list";
	}
	
	@Value("${file.location}")
	private String fileLocation;
	@Autowired
	private FileService service;
}