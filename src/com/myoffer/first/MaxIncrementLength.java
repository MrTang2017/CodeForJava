package com.myoffer.first;

import java.util.Arrays;

/*����һ��������������飬�ҵ���������������еĳ��ȡ�
 * ���� [10,9,2,5,3,7,101,18]
 * ���4
 */
public class MaxIncrementLength {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int maxans = 1;// ��������г���
		for (int i = 1; i < n; i++) {
			int maxval = 0;// ��i��β�����е���������еĳ���
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					maxval = Math.max(maxval, dp[j]);
			}
			dp[i] = 1 + maxval;
			maxans = Math.max(maxans, dp[i]);// �ҳ�����dp[0:n]������ֵ
		}
		return maxans;
	}

	public static int lengthOfLIS1(int[] nums) {
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

	// ���ֲ��ҵĶ�̬�滮����
	public static int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		//����
		for (int num : nums) {
			// ���ֲ��ң��ҵ�num��dp����ȷ��λ��
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
