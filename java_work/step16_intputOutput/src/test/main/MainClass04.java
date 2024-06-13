package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		PrintStream ps = System.out;

		// 1바이트 처리 스트림
		OutputStream os = ps;
		try {
			os.write(97);
			os.write(98);
			os.write(44032); // 한글처리 불가
			os.flush(); // 방출
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}