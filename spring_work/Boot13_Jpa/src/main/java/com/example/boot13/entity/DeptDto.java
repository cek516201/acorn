package com.example.boot13.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeptDto {
	public static DeptDto toDto(Dept dept) {
		List<String> names = dept.getList().stream().map(item->item.getEname()).toList();
		
		return DeptDto.builder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getList().size())
				.names(names)
				.build();
	}
	
	private int deptno;
	private String dname;
	private String loc;
	private int count; // 근무하는 인원 수
	private List<String> names; // 근무하는 사원의 이름들
}