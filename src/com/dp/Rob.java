package com.dp;

public class Rob {

	/**
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。 
	 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素 就是相邻的房屋装有相互连通的防盗系统，
	 * 如果两间相邻的房屋在同一晚上被小偷闯入，
	 * 系统会自动报警。 给定一个代表每个房屋存放金额的非负整数数组，
	 * 计算你在不触动警报装置的情况下，
	 * 能够偷窃到的最高金额。 输入: [1,2,3,1] 输出: 4 解释: 
	 * 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3
	 * 号房屋 (金额 = 3)。 偷窃到的最高金额 = 1 + 3 = 4 。
	 * 
	 * @param args
	 */

	public static int rob(int[] nums) {

		// 暴力方法
		/*
		 * int max=0; for(int i=0;i<nums.length;i++) { for(int j=i+2;j<nums.length;j++)
		 * { if (nums[i]+nums[j]>max) { max=nums[i]+nums[j]; } } } return max;
		 */

		// 动态规划
		/**
		 * dp[i]=max(dp[i-1],dp[i-2]+nums[i])
		 */

		int pre1 = 0, pre2 = 0;
		for (int i = 0; i < nums.length; i++) {
			int cur = Math.max(pre1, pre2 + nums[i]);
			pre2 = pre1;
			pre1 = cur;
		}
		return pre1;
	}

	/**
	 * 房屋围成一个圈
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob2(int[] nums) {

		/**
		 * dp[i]=max(dp[i-1],dp[i-2]+nums[i])
		 */

		int pre1 = 0, pre2 = 0;
		int result = 0;
		if (nums.length >= 2) {
			for (int i = 0; i < nums.length - 1; i++) {
				int cur = Math.max(pre1, pre2 + nums[i]);
				pre2 = pre1;
				pre1 = cur;
			}
			result = pre1;
			pre1 = 0;
			pre2 = 0;
			for (int i = 1; i < nums.length; i++) {
				int cur = Math.max(pre1, pre2 + nums[i]);
				pre2 = pre1;
				pre1 = cur;
			}
		}
		
		if (nums.length==1) {
			return nums[0];
		}
		return result > pre1 ? result : pre1;
	}

	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(rob(nums));
		System.out.println(rob2(nums));

	}

}
