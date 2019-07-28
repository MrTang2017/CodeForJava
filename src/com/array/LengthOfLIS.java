package com.array;

/**
 * �����������
 * 
 * @author ���� ����: [10,9,2,5,3,7,101,18] ���: 4 ����: ��������������� [2,3,7,101]�����ĳ����� 4��
 *
 *
 */

public class LengthOfLIS {

		public static int lengthOfLIS(int[] nums) {
			if (nums.length == 0)
				return 0;
			int n = nums.length;
			int[] dp = new int[n];
			dp[0] = 1;// ��ʼ������dp[0]Ϊ��β��������г���Ϊ1
			int maxans = 1;// ��������г���
			for (int i = 1; i < n; i++) {
				dp[i] = 1;// dp[i]����СֵΪ1
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				maxans = Math.max(maxans, dp[i]);// �ҳ�����dp[0:n]������ֵ
			}
			return maxans;
		}

	public static void main(String[] args) {
		int nums[] = { 4, 10, 4, 3, 8, 9 };
		System.out.println(lengthOfLIS(nums));
	}
}