package com.example.boot11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot11.dao.CafeCommentDao;
import com.example.boot11.dao.CafeDao;
import com.example.boot11.dto.CafeCommentDto;
import com.example.boot11.dto.CafeDto;
import com.example.boot11.exception.NotOwnerException;

@Service
public class CafeServiceImpl implements CafeService {
	@Override
	public void getList(Model model, CafeDto dto) {
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
		int totalRow=cafeDao.getCount(dto);
		//전체 페이지의 갯수 구하기
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다. 
		}
		
		//위에서 계산된 startRowNum 과 endRowNum 을 dto 담고
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//CafeDto 를 인자로 전달해서 글목록 얻어오기
		List<CafeDto> list=cafeDao.getList(dto);
		
		// view page 에 전달할 내용을 Model 객체에 담는다. 
		model.addAttribute("list", list);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("dto", dto); //키워드정보가 들어 있는 dto 를 모델에 담기 
		model.addAttribute("totalRow", totalRow);
	}

	@Override
	public void saveContent(CafeDto dto) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		dto.setWriter(userName);
		cafeDao.insert(dto);
	}

	@Override
	public void getDetail(Model model, CafeDto dto) {
		CafeDto resultDto = cafeDao.getDetail(dto);
		resultDto.setCondition(dto.getCondition());
		resultDto.setKeyword(dto.getKeyword());
		
		model.addAttribute("dto", resultDto);
	}

	@Override
	public void deleteContent(int num) {
		String writer = cafeDao.getData(num).getWriter();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!writer.equals(userName)) {
			throw new NotOwnerException("작성자와 일치하지 않습니다");
		}
		
		cafeDao.delete(num);
	}

	@Override
	public void getData(Model model, int num) {
		CafeDto dto = cafeDao.getData(num);
		model.addAttribute("dto", dto);
	}

	@Override
	public void updateContent(CafeDto dto) {
		String writer = cafeDao.getData(dto.getNum()).getWriter();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!writer.equals(userName)) {
			throw new NotOwnerException("작성자와 일치하지 않습니다");
		}
		
		cafeDao.update(dto);
	}
	
	
	
	@Override
	public void saveComment(CafeCommentDto dto) {
		
	}

	@Override
	public void deleteComment(int num) {
		
	}

	@Override
	public void updateComment(CafeCommentDto dto) {
		
	}

	@Override
	public void getCommentList(Model model, CafeCommentDto dto) {
		
	}
	
	//한 페이지에 글을 몇개씩 표시할 것인지
	final int PAGE_ROW_COUNT=2;
	//하단 페이지 UI를 몇개씩 표시할 것인지
	final int PAGE_DISPLAY_COUNT=2;
	@Autowired
	private CafeDao cafeDao;
	@Autowired
	private CafeCommentDao commentDao;
}