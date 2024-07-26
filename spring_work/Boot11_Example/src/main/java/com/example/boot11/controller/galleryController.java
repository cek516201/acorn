package com.example.boot11.controller;

import java.io.IOException;

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
	public String upload(MultipartFile image, String caption) {
		service.upload(image, caption);
		
		return "redirect:/gallery/list";
	}
	
	@GetMapping("/gallery/list")
	public String list(Model model, GalleryDto dto) {
		service.getList(model, dto);
		
		return "gallery/list";
	}
	
	@ResponseBody
	//@GetMapping("gallery/images/{saveFileName}")
	@GetMapping(
			value = "gallery/images/{imageName}",
			produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE}
	)
	public byte[] images(@PathVariable("imageName")String imageName) throws IOException {
		byte[] bytes = service.images(imageName);
		
		return bytes;
	}
	
	@GetMapping("/gallery/delete")
	public String delete(int num) {
		service.delete(num);
		
		return "redirect:/gallery/list";
	}
	
	@GetMapping("/gallery/detail")
	public String detail(Model model, GalleryDto dto) {
		service.getData(model, dto);
		
		return "gallery/detail";
	}
	
	@Autowired
	private GalleryService service;
}