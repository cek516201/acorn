package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("ㅁㅁㅁ");
		strList.add("ㄴㄴㄴ");
		strList.add("ㄷㄷㄷ");

		Consumer<String> con1 = new Consumer<String>() {
			@Override
			public void accept(String elem) {
				System.out.print(elem + " ");
			}
		};
		strList.forEach(con1);
		System.out.println();

		Consumer<String> con2 = (elem) -> {
			System.out.print(elem + " ");
		};
		strList.forEach(con2);
		System.out.println();

		strList.forEach((elem) -> {
			System.out.print(elem + " ");
		});
	}
}