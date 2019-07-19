package com.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数，返回组成这个整数的最少平方数 
 * 例如12=4+4+4 13=4+9
 * 
 * @author 汤吉
 *
 */
public class MinSqureNumber {

	/**
	 * dp算法，
	 * 
	 * @param n
	 * @return
	 */
	public static int minSqureNumber(int n) {

		if (n <= 0) {
			return 0;
		}
		// 累积到i的最少完全平方个数
		int[] dp = new int[n + 1];
		// 初始化
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			// 对于每个i,它必须是（i-j*j)以及一个完全平方数j*j的和
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}

		}
		return dp[n];
	}

	/**
	 * 静态动态规划
	 * 
	 * @param n
	 * @return
	 */
	public static int minSqureNumber2(int n) {

		if (n <= 0) {
			return 0;
		}

		List<Integer> list = new ArrayList<>();
		list.add(0);
		while (list.size() <= n) {

			int m = list.size();
			int curMin = Integer.MAX_VALUE;
			for (int j = 1; j * j <= m; j++) {
				curMin = Math.min(curMin, list.get(m - j * j) + 1);
			}
			list.add(curMin);
		}

		return list.get(n);
	}

	public static void main(String[] args) {
		System.out.println(minSqureNumber(48));
	}

}
