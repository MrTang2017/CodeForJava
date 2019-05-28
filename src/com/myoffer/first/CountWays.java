package com.myoffer.first;

public class CountWays {

	// 暴力递归法
	public static int countWays(int[] penny, int n, int aim) {
		if (n <= 0 || aim > 1000 || aim <= 0) {
			return 0;
		}
		return findMethodNum(penny, 0, aim);
	}

	private static int findMethodNum(int[] penny, int index, int aim) {
		// 找到一种方法
		if (aim == 0)
			return 1;
		// 没有找到方法
		if (index == penny.length)
			return 0;
		int res = 0;// 总的方法数
		int k = aim / penny[index];// 最多需要多少张penny[index]元货币来兑换aim
		for (int i = 0; i <= k; i++) {
			res = res + findMethodNum(penny, index + 1, aim - penny[index] * i);
		}
		return res;
	}
	//动态规划
	public static int countWays2(int[] penny,int n,int aim) {
		if(n<=0 || aim<=0) {
			return 0;
		}
		int[][] dp=new int[n][aim+1];
		//初始化
		for(int i=0;i<n;i++)
			dp[i][0]=1;
		//初始化，表示金额j是货币penny[0]的整数倍
		for(int j=1;j<aim+1;j++)
			dp[0][j]=j%penny[0]==0?1:0;
		//从arr[1]开始
		for(int i=1;i<n;i++) {
			for(int j=1;j<aim+1;j++) {
				int count=0;
				/*
				 * dp[i][j]=
				 * dp[i-1][j-0*penny[i]]+
				 * dp[i-1][j-1*penny[i]]+
				 * dp[i-1][j-2*penny[i]]+
				 * ....
				 */
				for(int k=0;penny[i]*k<=j;k++)
					count+=dp[i-1][j-penny[i]*k];
				//dp[i][j]表示组成金额j的货币arr[:i]的方法数
				dp[i][j]=count;
			}
			
		}
		return dp[n-1][aim];
	}

	
	public static void main(String[] args) {
		//测试
		int[] coins= {1,2,5};
		int aim=11;
		System.out.println(countWays2(coins, 3, aim));
	}

}
