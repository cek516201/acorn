package test.dto;

import java.io.Serializable;

//ObjectOutputStream 객체를 이용해서 객체를 출력하려면 Serializable 인터페이스가 구현되어 있어야한다
public class MemberDto implements Serializable {
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