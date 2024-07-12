package com.example.boot11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot11.dto.FileDto;
import com.example.boot11.service.FileService;
import com.example.boot11.service.UserService;

@Controller
public class FileController {
	@GetMapping("/file/list")
	public String list(Model model) {
		List<FileDto> list = service.selectAll();
		model.addAttribute("list", list);
		
		return "file/list";
	}
	
	@ResponseBody
	@GetMapping("/file/download")
	public String download(FileDto dto) {
		int num = dto.getNum();
		String orgFileName = dto.getOrgFileName();
		String saveFileName = dto.getSaveFileName();
		long fileSize = dto.getFileSize();
//
//		// 응답 헤더 정보 설정
//		response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
//		// 다운로드 시켜줄 파일명 인코딩
//		String encodedName = URLEncoder.encode(orgFileName, "utf-8");
//		// 파일명에 공백이있는 경우 처리
//		encodedName = encodedName.replaceAll("\\+", " ");
//
//		response.setHeader("Content-Disposition", "attachment;filename=" + encodedName);
//		response.setHeader("Content-Transfer-Encoding", "binary");
//
//		// 다운로드할 파일의 크기
//		response.setContentLengthLong(fileSize);
//
//		// 다운로드 시켜줄 파일의 실제 경로
//		String path = request.getServletContext().getRealPath("/upload") + File.separator + saveFileName;
//
//		FileInputStream fis = null;
//		BufferedOutputStream bos = null;
//		try {
//			// 파일에서 byte 을 읽어들일 객체
//			fis = new FileInputStream(path);
//			// 클라이언트에게 출력할수 있는 스트림 객체 얻어오기
//			bos = new BufferedOutputStream(response.getOutputStream());
//			// 한번에 최대 1M byte 씩 읽어올수 있는 버퍼
//			byte[] buffer = new byte[1024 * 1024];
//			int readedByte = 0;
//			// 반복문 돌면서 출력해주기
//			while (true) {
//				// byte[] 객체를 이용해서 파일에서 byte 알갱이 읽어오기
//				readedByte = fis.read(buffer);
//				if (readedByte == -1)
//					break; // 더이상 읽을 데이터가 없다면 반복문 빠져 나오기
//				// 읽은 만큼 출력하기
//				bos.write(buffer, 0, readedByte);
//				bos.flush(); // 출력
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (fis != null)
//				fis.close();
//			if (bos != null)
//				bos.close();
//		}
		
		return "download " + num + " " + orgFileName + " " + saveFileName + " " + fileSize;
	}
	
	@Autowired
	private FileService service;
}