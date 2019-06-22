package com.dp;

public class NumberOfArithmeticSlices {

	/**
	 * ���һ����������������Ԫ�أ� ����������������Ԫ��֮����ͬ�� ��Ƹ�����Ϊ�Ȳ����С� A = [1, 2, 3, 4] ����: 3, A
	 * ���������ӵȲ�����: [1, 2, 3], [2, 3, 4] �Լ����� [1, 2, 3, 4]��
	 * 
	 * @param args
	 */

	public static int numberOfArithmetricSlices(int[] nums) {
		// ��������
		if (nums.length <= 2) {
			return 0;
		}
		int start = 0;
		int count = 0;
		while (start < nums.length) {
			if (isArithmetrics(nums, start, start + 2)) {
				count += 1;
				for (int k = start + 3; k < nums.length; k++) {
					if ((nums[k] - nums[k - 1]) != (nums[start + 2] - nums[start + 1])) {
						break;
					}
					count += 1;
				}
			}
			start += 1;
			if (start + 2 >= nums.length) {
				break;
			}
		}

		return count;

	}

	private static boolean isArithmetrics(int[] nums, int start, int end) {
		int diff = nums[start + 1] - nums[start];
		for (int i = start + 2; i <= end; i++) {
			if ((nums[i] - nums[i - 1]) != diff) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 8, 5, 9, 7 };
		System.out.println(numberOfArithmetricSlices(nums));

	}

}
