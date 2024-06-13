package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass11 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\1.png");
			FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\copy.png");

			while (true) {
				int readedByte = fis.read();
				System.out.println(readedByte);

				if (readedByte == -1)
					break;

				fos.write(readedByte);
				fos.flush();
			}

			System.out.println("copy 완료");
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}