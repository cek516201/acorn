package test.mypac;

// RuntimeException 클래스를 상속받아서 만든다
public class WowException extends RuntimeException {

	public WowException(String msg) {
		super(msg);
	}
}