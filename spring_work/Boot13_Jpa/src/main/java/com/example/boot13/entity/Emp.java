package com.example.boot13.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp {
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
//	private Integer deptno;

	// Emp 객체 하나는 사원 한명의 기본정보를 가지고있다
	// Dept 객체 하나는 부서 하나의 정보를 가지고있다
	// Emp 객체 안에 하나있는 Dept 객체는 Emp객체가 가지고 있는 해당 사원의 부서정보를 가진다
	
	// ManyToOne 또는 OneToOne 관계는 다른 Entity를 필드로 가지고 있는다
	// ManyToOne 또는 OneToOne
	
	@ManyToOne // 많은 Emp가 하나의 Dept에 속해 있다
	// 이 칼럼의 이름은 deptno이고 Dept Entity의 deptno를 참조한다
	@JoinColumn(name = "deptno")
	private Dept dept;
}