package test.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		MemberDto dto = new MemberDto(1, "ㅁㅁㅁ", "aaa");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main\\member.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(dto);
			System.out.println("파일에 객체 저장 성공");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}