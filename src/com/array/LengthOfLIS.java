package com.array;

/**
 * 最长递增子序列
 * 
 * @author 汤吉 输入: [10,9,2,5,3,7,101,18] 输出: 4 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 *
 */

public class LengthOfLIS {

		public static int lengthOfLIS(int[] nums) {
			if (nums.length == 0)
				return 0;
			int n = nums.length;
			int[] dp = new int[n];
			dp[0] = 1;// 初始化，以dp[0]为结尾的最长子序列长度为1
			int maxans = 1;// 最长递增序列长度
			for (int i = 1; i < n; i++) {
				dp[i] = 1;// dp[i]的最小值为1
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				maxans = Math.max(maxans, dp[i]);// 找出所以dp[0:n]中最大的值
			}
			return maxans;
		}

	public static void main(String[] args) {
		int nums[] = { 4, 10, 4, 3, 8, 9 };
		System.out.println(lengthOfLIS(nums));
	}
}