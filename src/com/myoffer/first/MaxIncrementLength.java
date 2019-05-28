package com.myoffer.first;

import java.util.Arrays;

/*给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 例如 [10,9,2,5,3,7,101,18]
 * 输出4
 */
public class MaxIncrementLength {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int maxans = 1;// 最长递增序列长度
		for (int i = 1; i < n; i++) {
			int maxval = 0;// 以i结尾的序列的最长递增序列的长度
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					maxval = Math.max(maxval, dp[j]);
			}
			dp[i] = 1 + maxval;
			maxans = Math.max(maxans, dp[i]);// 找出所以dp[0:n]中最大的值
		}
		return maxans;
	}

	public static int lengthOfLIS1(int[] nums) {
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

	// 二分查找的动态规划方法
	public static int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		//遍历
		for (int num : nums) {
			// 二分查找，找到num在dp中正确的位置
			int i = Arrays.binarySearch(dp, 0, len, num);
			System.out.println(i);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	public int lengthOfLIS3(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;
	}

	public static void main(String[] args) {
		int[] test = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS2(test));
	}
}
