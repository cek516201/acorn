package test.mypac;

// 추상 메소드가 1개인 인터페이스는 좀 더 특별한 모양으로 사용될 수 있다

public interface Drill {
	public static final String COMPANY = "LG";

	public void hole(); // 구멍을 뚫는 추상 메소드는 1개
}