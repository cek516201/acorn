package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass08 {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\file.txt");

		try {
			FileReader fr = new FileReader(f);
			while (true) {
				int code = fr.read();
				if (code == -1) {
					break;
				}

				System.out.print((char) code);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}