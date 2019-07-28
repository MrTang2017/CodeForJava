package com.dp;


/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 
 * 返回你可以获得的最大乘积。
 * @author 汤吉
 *
 */
public class IntegerBreak {
	/**
	 * 动态规划
	 * @param n
	 * @return
	 */
	
	public int integerBreak(int n) {

		if (n <= 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		if (n == 3) {
			return 2;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		int max = 0;
		for (int i = 4; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				int cur = dp[j] * dp[i - j];
				if (cur > max) {
					max = cur;
				}
			}
			dp[i] = max;
		}

		return dp[n];
	}
	
	/**
	 * 贪心算法，
	 * n>=5,先分割长度为3，当剩下的长度为4时，分为2个长度为2的段
	 * @param n
	 * @return
	 */
	
	public int integerBreak2(int n) {

		if (n <= 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}

		if (n == 3) {
			return 2;
		}
		int countOf3=n/3;
		//此处为分割2个长度为2的段
		if ((n-countOf3*3)==1) {
			countOf3-=1;
		}
		
		int countOf2=(n-countOf3*3)/2;
		return (int)Math.pow(3, countOf3)*(int)Math.pow(2, countOf2);

		
	}
	

	public static void main(String[] args) {
		
		System.out.println(new IntegerBreak().integerBreak(8));
		

	}

}
