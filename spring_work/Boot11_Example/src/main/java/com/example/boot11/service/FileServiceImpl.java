package com.example.boot11.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dao.FileDao;
import com.example.boot11.dto.FileDto;
import com.example.boot11.exception.NotOwnerException;

@Service
public class FileServiceImpl implements FileService {
	@Override
	public List<FileDto> getList(Model model) {
		List<FileDto> list = dao.getList();
		model.addAttribute("list", list);
		
		return list;
	}

	@Override
	public void delete(int num) {
		FileDto dto = dao.select(num);
		// 로그인된 사용자와 파일의 소유자가 같은지 확인해서 다르면 exception 발생시키기
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!userName.equals(dto.getWriter())) {
			throw new NotOwnerException("작성자와 일치하지 않습니다");
		}
		
		// 파일 시스템에서 실제로 삭제
		String filePath = fileLocation + File.separator + dto.getSaveFileName();
		File file = new File(filePath);
		file.delete();
		
		dao.delete(num);
	}

	@Override
	public void insert(FileDto dto) {
		//파일 업로드 처리를 위한 객체의 참조값 얻어오기(업로드된 파일에 대한 정보를 얻어낼 객체)
		MultipartFile myFile=dto.getFile();
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//파일의 크기
		long fileSize=myFile.getSize();
		//저장할 파일명을 하나 얻어낸다. 
		String saveFileName=UUID.randomUUID().toString();
		//저장할 파일의 상세 경로
		String filePath = fileLocation+File.separator+saveFileName;
		try {
			//File 객체 생성 
			File f=new File(filePath);
			//파일을 원하는 곳에 저장하기 
			myFile.transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//DB 에 업로드된 파일에 대한 정보를 저장한다.
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
		dto.setWriter(userName);
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		
		dao.insert(dto);
	}

	@Override
	public ResponseEntity<InputStreamResource> download(int num) {
		//다운로드 해줄 파일의 정보를 DB 에서 읽어온다.
		FileDto dto=dao.select(num);
		ResponseEntity<InputStreamResource> responseEn=null;
		try {
			//다운로드 시켜줄 원본 파일명
			String encodedName=URLEncoder.encode(dto.getOrgFileName(), "utf-8");
			//파일명에 공백이 있는경우 파일명이 이상해지는걸 방지
			encodedName=encodedName.replaceAll("\\+"," ");
			//응답 헤더정보(스프링 프레임워크에서 제공해주는 클래스) 구성하기 (웹브라우저에 알릴정보)
			HttpHeaders headers=new HttpHeaders();
			//파일을 다운로드 시켜 주겠다는 정보
			headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream"); 
			//파일의 이름 정보(웹브라우저가 해당정보를 이용해서 파일을 만들어 준다)
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+encodedName);
			//파일의 크기 정보도 담아준다.
			headers.setContentLength(dto.getFileSize());
			//읽어들일 파일의 경로 구성
			String filePath=fileLocation + File.separator + dto.getSaveFileName();
			//파일에서 읽어들일 스트림 객체 생성
			InputStream is=new FileInputStream(filePath);
			//InputStreamResource
			InputStreamResource isr=new InputStreamResource(is);
			//InputStremResource 객체를 얻어내서 지역변수에 담고
			responseEn=ResponseEntity.ok().headers(headers).body(isr);
		}catch(Exception e) {
			//예외를 던지고 ExceptionController 에서 처리 할수 있다.
			throw new RuntimeException("파일 다운로드 중에 예외가 발생했습니다");
		}
		//InputStreamResource 객체를 리턴해준다.
		return responseEn;
	}
	
	@Value("${file.location}")
	private String fileLocation;
	@Autowired
	private FileDao dao;
}