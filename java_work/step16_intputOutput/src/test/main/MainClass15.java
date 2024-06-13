package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import test.dto.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\member.dat");
			ois = new ObjectInputStream(fis);
			MemberDto dto = (MemberDto) ois.readObject();
			System.out.printf("%d %s %s", dto.getNum(), dto.getName(), dto.getAddr());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}