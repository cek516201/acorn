package com.example.boot11.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dao.GalleryDao;
import com.example.boot11.dto.GalleryDto;
import com.example.boot11.exception.NotOwnerException;

@Service
public class GalleryServiceImpl implements GalleryService{
	@Override
	public void upload(MultipartFile file, String caption) {
		String writer = SecurityContextHolder.getContext().getAuthentication().getName();
		
		//원본 파일명
		String orgFileName = file.getOriginalFilename();
		//파일의 크기
		long fileSize = file.getSize();
		//저장할 파일명을 하나 얻어낸다. 
		String saveFileName = UUID.randomUUID().toString();
		//저장할 파일의 상세 경로
		String filePath = fileLocation + File.separator + saveFileName;
		try {
			//File 객체 생성 
			File f = new File(filePath);
			//파일을 원하는 곳에 저장하기 
			file.transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		GalleryDto dto = GalleryDto.builder().writer(writer).caption(caption).saveFileName(saveFileName).build();
	
		dao.insert(dto);
	}
	
	@Override
	public List<GalleryDto> getList(Model model, GalleryDto dto) {
		List<GalleryDto> list = dao.getList(dto);
		model.addAttribute("list", list);
		
		
		
		model.addAttribute("dto", dto);
		
		return list;
	}
	
	@Override
	public byte[] images(String name) throws IOException {
		// imageName 경로 변수에 들어있는 문자열이 매개변수 String name에 전달된다
		String absolutePath = fileLocation + File.separator + name;
		InputStream is = new FileInputStream(absolutePath);
		
		return IOUtils.toByteArray(is);
	}
	
	@Override
	public void delete(int num) {
		GalleryDto dto = dao.getDto(num);
		
		String writer = dto.getWriter();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!writer.equals(userName)) {
			throw new NotOwnerException("작성자와 일치하지 않습니다");
		}
		
		// 파일 시스템에서 실제로 삭제
		String saveFileName = dto.getSaveFileName();
		String filePath = fileLocation + File.separator + saveFileName;
		File file = new File(filePath);
		file.delete();
		
		dao.delete(num);
	}
	
	@Override
	public void detail(GalleryDto dto, Model model) {
		GalleryDto detailDto = dao.getDetail(dto);
		model.addAttribute("detailDto", detailDto);
		model.addAttribute("dto", dto);
	}
	
	@Autowired
	private GalleryDao dao;
	@Value("${file.location}")
	private String fileLocation;
}