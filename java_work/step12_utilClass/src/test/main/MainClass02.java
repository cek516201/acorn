package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass02 {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.remove((Integer) 2);

		for (int i = 0; i < intList.size(); i++) {
			System.out.print(intList.get(i) + " ");
		}
		System.out.println();

		// 확장 for문
		for (var elem : intList) {
			System.out.print(elem + " ");
		}
	}
}