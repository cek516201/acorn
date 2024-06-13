package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain {
	public static void main(String[] args) {
		List<Long> longList = new ArrayList<Long>(10);

		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			longList.add(ran.nextLong(Long.MIN_VALUE, Long.MAX_VALUE));
		}

		// 중복 제거
		Set<Long> longSet = new HashSet<Long>(longList);
		longList = new ArrayList<Long>(longSet);

		Collections.sort(longList);

		for (var elem : longList) {
			System.out.println(elem);
		}
	}
}