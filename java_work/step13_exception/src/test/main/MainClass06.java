package test.main;

import java.io.File;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main \"시작\"");

		// 파일 생성
		// File f = new
		// File("C:\\Users\\user\\playground\\java_work\\step13_exception\\src\\test\\main\\MainClass06\\memo.txt");
		File f = new File("C:/Users/user/playground/java_work/step13_exception/src/test/main/MainClass06/memo.txt");
		while (true) {
			try {
				if (f.exists()) {
					System.out.println("delete");
					f.delete();
				} else {
					System.out.println("create");
					f.createNewFile();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}