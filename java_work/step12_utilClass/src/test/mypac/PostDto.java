package test.mypac;

public class PostDto {
	public PostDto() {

	}

	public PostDto(int num, String title, String writer) {
		this.num = num;
		this.title = title;
		this.writer = writer;
	}

	public static int getNextNum() {
		return ++currentNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	private static int currentNum = 0;
	private int num;
	private String title;
	private String writer;
}