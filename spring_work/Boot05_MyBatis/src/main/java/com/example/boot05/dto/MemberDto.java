package com.example.boot05.dto;

import org.apache.ibatis.type.Alias;

// 별칭 부여
@Alias("memberDto")
public class MemberDto {
	public MemberDto() {
		
	}
	
	public MemberDto(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	private int num;
	private String name;
	private String addr;
}