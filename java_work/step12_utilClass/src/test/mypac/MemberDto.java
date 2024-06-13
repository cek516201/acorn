package test.mypac;

// Dto -> Data Transfer Object 

// 1. 디폴트 생성자가 반드시 있어야한다
// 2. 필드는 접근지정자가 private
// 3. 필드의 접근 메소드 getter, setter 메소드가 있어야 한다.
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