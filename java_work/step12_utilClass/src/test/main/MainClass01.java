package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass01 {
	public static void main(String[] args) {
		// 자바에서 배열은 공간을 늘리거나 줄일 수 없다
		String[] names = new String[3];
		names[0] = "ㅁ";
		names[1] = "ㄴ";
		names[2] = "ㅇ";

		List<String> strList = new ArrayList<String>(10);
		strList.add("a");
		strList.add("a");
		strList.add("d");
		strList.add("f");
		strList.add("g");
		var item = strList.get(0);
		strList.remove("a");
		strList.add(0, "acorn");
		strList.set(1, "ab");
		int size = strList.size();
		// strArray.clear();

		for (var elem : strList) {
			System.out.print(elem + " ");
		}
	}
}