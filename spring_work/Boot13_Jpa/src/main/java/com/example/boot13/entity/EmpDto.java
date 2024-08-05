package com.example.boot13.entity;

import java.text.SimpleDateFormat;
import java.util.Locale;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpDto {
	public static EmpDto toDto(Emp emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String hiredate = sdf.format(emp.getHiredate());
		
		return EmpDto.builder()
				.empno(emp.getEmpno())
				.ename(emp.getEname())
				.job(emp.getJob())
				.mgr(emp.getMgr() == null ?  0 : emp.getMgr())
				.hiredate(hiredate)
				.sal(emp.getSal())
				.comm(emp.getComm() == null ?  0 : emp.getComm())
				.deptno(emp.getDept().getDeptno())
				.build();
	}
	
	@Id
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private Integer deptno;
}