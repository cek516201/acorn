package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;

		// 1바이트 처리 스트림
		OutputStream os = ps;

		// 2바이트 처리 스트림
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		try {
			bw.write("하나");
			bw.newLine(); // 운영체제에 맞는 개행기호를 자동으로 출력
							// window : \r\n
							// linux, mac os : \n
			bw.write("둘");
			bw.newLine();
			bw.write("셋");
			bw.newLine();
			bw.write("야!");
			bw.flush(); // 방출
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}