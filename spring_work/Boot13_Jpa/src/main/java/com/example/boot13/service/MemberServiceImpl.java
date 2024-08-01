package com.example.boot13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot13.entity.Member;
import com.example.boot13.entity.MemberDto;
import com.example.boot13.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Override
	public void getList(Model model) {
//		List<Member> enList = repo.findAll();
//		List<Memberdto> list = new ArrayList<Memberdto>();
//		for (Member tmp : enList) {
//			Memberdto dto = Memberdto.toDto(tmp);
//			list.add(dto);
//		}
		
//		List<MemberDto> list = repo.findAll().stream().map(item -> MemberDto.toDto(item)).toList();
		
		// 메소드 참조 표현식
		// 클래스명 :: 메소드명
//		List<MemberDto> list = repo.findAll().stream().map(MemberDto::toDto).toList();
		
		List<MemberDto> list = repo.findAllByOrderByNumDesc().stream().map(MemberDto::toDto).toList();

		model.addAttribute("list", list);
	}

	@Override
	public void insert(MemberDto dto) {
		Member m = Member.toEntity(dto);
		
		repo.save(m);
	}

	@Override
	public void delete(Long num) {
		repo.deleteById(num);
	}

	@Override
	public void getData(Long num, Model model) {
		Member m = repo.findById(num).get();
		MemberDto dto = MemberDto.toDto(m);
		
		model.addAttribute("dto", dto);
	}

	@Override
	public void update(MemberDto dto) {
		// save() 메소드는 insert와 update 겸용이다
		Member m = Member.toEntity(dto);
		
		repo.save(m);
	}
	
	// 만일 @Transactional이라는 어노테이션이 서비스 메소드에 붙어있으면
	// 해당 메소드 안에서 Entity를 수정하면 수정된 내용이 DB에 반영된다
	// (수정할때는 Repository의 메소드를 이용해서 수정하는것이 좋다)
	@Transactional
	@Override
	public void update2(MemberDto dto) {
		Member m1 = repo.findById(dto.getNum()).get();
		Member m2 = repo.findById(dto.getNum()).get();
		System.out.println(m1 == m2); // true
		m1.setName(dto.getName());
		m1.setAddr(dto.getAddr());
	}

	@Autowired
	private MemberRepository repo;
}