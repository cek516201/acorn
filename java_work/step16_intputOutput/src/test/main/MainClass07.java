package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass07 {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\file.txt");

		if (!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("create file.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write("456\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}