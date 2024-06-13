package test.mypac;

public class Member {
	public Member() {

	}

	public Member(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() { return num; }
	public String getName() { return name; }
	public String getAddr() { return addr; }
	
	private int num;
	private String name;
	private String addr;
}