package test.friend.dto;

public class FriendDto {
	public FriendDto() {
		
	}

	public FriendDto(int num, String name, String phoneNumber) {
		this.num = num;
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private int num;
	private String name;
	private String phoneNumber;
}