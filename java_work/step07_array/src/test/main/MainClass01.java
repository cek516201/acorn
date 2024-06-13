package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		double[] nums2 = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		boolean[] bools = { true, false, true, false, true };
		String[] names = { "a", "ab", "abc", "abcd", "abcde" };

		// 복제본 얻어내기
		int[] result = nums.clone(); // 깊은 복사
		int[] result2 = nums; // 참조값 복사
		nums[0] = 0;
		System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4]);
		System.out.println(result2[0] + " " + result2[1] + " " + result2[2] + " " + result2[3] + " " + result2[4]);

		int size = nums.length;

		int first = nums[0];
		int second = nums[1];
		int third = nums[2];
	}
}