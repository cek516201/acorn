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
	public void getList(Model model, GalleryDto dto) {
		// pageNum 에 해당하는 글정보를 select 에서 Model 객체에 담는 작업을 하면 된다.
		int pageNum=dto.getPageNum();
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//전체 글의 갯수
		int totalRow=dao.getCount(dto);
		//전체 페이지의 갯수 구하기
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다. 
		}
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		model.addAttribute("dto", dto);
		
		List<GalleryDto> list = dao.getList(dto);
		model.addAttribute("list", list);
		
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalRow", totalRow);
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
		GalleryDto dto = dao.getData(GalleryDto.builder().num(num).build());
		
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
	public void getData(Model model, GalleryDto dto) {
		GalleryDto data = dao.getData(dto);
		model.addAttribute("detailDto", data);
		model.addAttribute("dto", dto);
	}
	
	@Autowired
	private GalleryDao dao;
	@Value("${file.location}")
	private String fileLocation;
	//한 페이지에 글을 몇개씩 표시할 것인지
	private final int PAGE_ROW_COUNT=3;
	//하단 페이지 UI를 몇개씩 표시할 것인지
	private final int PAGE_DISPLAY_COUNT=1;
}