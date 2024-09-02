package com.example.boot14.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot14.dto.CafeCommentDto;
import com.example.boot14.dto.CafeDto;
import com.example.boot14.repository.CafeCommentDao;
import com.example.boot14.repository.CafeDao;

@Service
public class CafeServiceImpl implements CafeService {
	@Override
	public Map<String, Object> getList(CafeDto dto) {
		// CafeDto 로 부터 페이지 번호를 얻어낸다
		int pageNum = dto.getPageNum();
		// 보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		// 하단 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;

		// 전체 글의 갯수
		int totalRow = cafeDao.getCount(dto);
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount; // 보정해 준다.
		}

		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		List<CafeDto> list = cafeDao.getList(dto);

		return Map.of("list", list,
				"startPageNum", startPageNum,
				"endPageNum", endPageNum,
				"totalPageCount", totalPageCount,
				"pageNum", pageNum,
				"totalRow", totalRow);
	}

	@Override
	public void saveContent(CafeDto dto) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		dto.setWriter(userName);

		cafeDao.insert(dto);
	}

	@Override
	public Map<String, Object> getDetail(CafeDto dto) {
		CafeDto resultDto = cafeDao.getDetail(dto);
		resultDto.setCondition(dto.getCondition());
		resultDto.setKeyword(dto.getKeyword());
		
		return Map.of("dto", resultDto);
	}

	@Override
	public void deleteContent(int num) {
		cafeDao.delete(num);
	}

	@Override
	public void getData(Model model, int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContent(CafeDto dto) {
		cafeDao.update(dto);
	}

	@Override
	public CafeCommentDto saveComment(CafeCommentDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getCommentList(CafeCommentDto dto) {

		return null;
	}

	@Override
	public void deleteComment(int num) {
		cafeCommentDao.delete(num);
	}

	@Override
	public void updateComment(CafeCommentDto dto) {
		cafeCommentDao.update(dto);
	}

	@Autowired
	private CafeDao cafeDao;
	@Autowired
	private CafeCommentDao cafeCommentDao;
	// 한 페이지에 글을 몇개씩 표시할것인지
	private final int PAGE_ROW_COUNT = 2;
	// 하단 페이지 UI를 몇개씩 표시할것인지
	private final int PAGE_DISPLAY_COUNT = 2;
}