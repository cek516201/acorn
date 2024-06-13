package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\1.png");
			fos = new FileOutputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\copy.png");

			byte[] buffer = new byte[1024];

			while (true) {
				int readedCount = fis.read(buffer); // 읽어들인 갯수가 리턴된다
				System.out.println(readedCount + " 바이트 읽음");

				if (readedCount == -1)
					break;

				fos.write(buffer, 0, readedCount);
				fos.flush();
			}

			System.out.println("copy 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// null 체크를 한 후에 마무리 메소드를 호출한다
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}