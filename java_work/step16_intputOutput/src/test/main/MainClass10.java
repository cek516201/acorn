package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass10 {
	public static void main(String[] args) {
		// 문자열을 누적시킨다음 한번에 문자열을 얻어낼 수 있는 객체 생성
		StringBuilder sb = new StringBuilder();

		File f = new File("C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\file.txt");

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				// 읽어낸 문자열을 누적
				sb.append(line + System.lineSeparator());
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(sb.toString());
	}
}