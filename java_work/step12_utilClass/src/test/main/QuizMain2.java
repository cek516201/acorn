package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain2 {
	public static void main(String[] args) {
		Set<Integer> lottoNums = new HashSet<Integer>(6);

		Random ran = new Random();
		while (lottoNums.size() < 6) {
			lottoNums.add(ran.nextInt(1, 46));
		}

		List<Integer> intList = new ArrayList<Integer>(lottoNums);
		Collections.sort(intList);

		for (var elem : intList) {
			System.out.print(elem + " ");
		}
	}
}