package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;

		int[] nums2 = new int[500];
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = i + 1;
			System.out.print(nums2[i] + " ");
		}
	}
}