package com.dp;

public class Rob {

	/**
	 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ� 
	 * ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���� �������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
	 * ����������ڵķ�����ͬһ���ϱ�С͵���룬
	 * ϵͳ���Զ������� ����һ������ÿ�����ݴ�Ž��ķǸ��������飬
	 * �������ڲ���������װ�õ�����£�
	 * �ܹ�͵�Ե�����߽� ����: [1,2,3,1] ���: 4 ����: 
	 * ͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3
	 * �ŷ��� (��� = 3)�� ͵�Ե�����߽�� = 1 + 3 = 4 ��
	 * 
	 * @param args
	 */

	public static int rob(int[] nums) {

		// ��������
		/*
		 * int max=0; for(int i=0;i<nums.length;i++) { for(int j=i+2;j<nums.length;j++)
		 * { if (nums[i]+nums[j]>max) { max=nums[i]+nums[j]; } } } return max;
		 */

		// ��̬�滮
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
	 * ����Χ��һ��Ȧ
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
