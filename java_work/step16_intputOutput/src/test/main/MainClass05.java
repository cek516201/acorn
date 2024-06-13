package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps = System.out;

		// 1바이트 처리 스트림
		OutputStream os = ps;

		// 2바이트 처리 스트림
		OutputStreamWriter osw = new OutputStreamWriter(os);

		try {
			osw.write(97);
			osw.write(98);
			osw.write(44032); // 한글처리 가능
			osw.write("나\n다라");
			osw.flush(); // 방출
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}