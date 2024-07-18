package com.example.boot11.service;

import org.springframework.ui.Model;

import com.example.boot11.dto.CafeCommentDto;
import com.example.boot11.dto.CafeDto;

public interface CafeService {
	public void getList(Model model, CafeDto dto);
	public void saveContent(CafeDto dto);
	public void getDetail(Model model, CafeDto dto); // 글 자세히 보기
	public void deleteContent(int num);
	public void getData(Model model, int num); // 글 수정 폼을 출력하기 위해
	public void updateContent(CafeDto dto);
	
	public void saveComment(CafeCommentDto dto); // 댓글 저장
	public void deleteComment(int num); // 댓글 삭제
	public void updateComment(CafeCommentDto dto); // 댓글 수정
	public void getCommentList(Model model, CafeCommentDto dto); // 댓글 목록을 model에 담기
}