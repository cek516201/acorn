package test.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public class MainClass11 {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(10);
		intList.add(20);
		intList.add(20);
		intList.add(30);
		intList.add(30);

		Collection<Integer> intCol = intList;

		// 중복 제거
		Set<Integer> intSet = new HashSet<Integer>(intList);
		intList = new ArrayList<Integer>(intSet);

		// 정렬
		Collections.sort(intList); // 오름차순
		Collections.sort(intList, Collections.reverseOrder()); // 내림차순
	}
}