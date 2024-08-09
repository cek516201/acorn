package com.example.boot14.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot14.dto.GalleryDto;
import com.example.boot14.repository.GalleryDao;

@Service
public class GalleryServiceImpl implements GalleryService{
	final int  PAGE_ROW_COUNT = 2;
	final int  PAGE_DISPLAY_COUNT = 2;
	
	@Override
	public Map<String, Object> selectPage(int pageNum) {
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		
		//startRowNum 과 endRowNum  을 GalleryDto 객체에 담고
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//GalleryDao 객체를 이용해서 회원 목록을 얻어온다.
		List<GalleryDto> list = dao.getList(dto);
	   
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		//전체 row 의 갯수
		int totalRow = dao.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount; //보정해 준다. 
		}
		
		Map<String, Object> map = Map.of("list", list,
				"startPageNum", startPageNum,
				"endPageNum", endPageNum,
				"totalPageCount", totalPageCount,
				"pageNum", pageNum);
		
		return map;
	}
	
	@Autowired
	private GalleryDao dao;
}