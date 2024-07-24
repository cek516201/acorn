package com.example.boot11.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;
import com.example.boot11.service.GalleryService;

@Controller
public class galleryController {
	@GetMapping("/gallery/uploadform")
	public String uploadform() {
		return "gallery/uploadform";
	}
	@PostMapping("/gallery/upload")
	public String upload(MultipartFile file, String caption) {
		service.upload(file, caption);
		
		return "redirect:/gallery/list";
	}
	
	@GetMapping("/gallery/list")
	public String getMethodName(Model model) {
		List<GalleryDto> list = service.getList();
		model.addAttribute("list", list);
		
		return "gallery/list";
	}
	
	@ResponseBody
	//@GetMapping("gallery/images/{saveFileName}")
	@GetMapping(
			value = "gallery/images/{saveFileName}",
			produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE}
	)
	public byte[] images(@PathVariable("saveFileName")String name) throws IOException {
		byte[] bytes = service.images(name);
		
		return bytes;
	}
	
	@ResponseBody
	@GetMapping("/gallery/delete")
	public String delete(int num) {
		service.delete(num);
		
		return "delete " + num;
	}
	
	@Autowired
	private GalleryService service;
}