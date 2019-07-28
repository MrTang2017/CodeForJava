package com.dp;

public class NumberOfArithmeticSlices {

	/**
	 * 如果一个数列至少有三个元素， 并且任意两个相邻元素之差相同， 则称该数列为等差数列。 A = [1, 2, 3, 4] 返回: 3, A
	 * 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
	 * 
	 * @param args
	 */

	public static int numberOfArithmetricSlices(int[] nums) {
		// 暴力方法
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

	/**
	 * dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。
	 * 当 A[i] - A[i-1] == A[i-1] - A[i-2]，
	 * 那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。
	 * 而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，
	 * 一样可以构成新的递增子区间。 
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices2(int[] A) {
	    if (A == null || A.length == 0) {
	        return 0;
	    }
	    int n = A.length;
	    int[] dp = new int[n];
	    for (int i = 2; i < n; i++) {
	        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
	            dp[i] = dp[i - 1] + 1;
	        }
	    }
	    int total = 0;
	    for (int cnt : dp) {
	        total += cnt;
	    }
	    return total;
	}
	
	
	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 8, 5, 9, 7 };
		System.out.println(numberOfArithmetricSlices(nums));

	}

}
