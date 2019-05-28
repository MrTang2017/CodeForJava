package com.myoffer.first;

import java.util.Arrays;

/*给定不同金额的硬币coins和一个总金额，编写一下函数来计算
可以凑成总金额所需最少的硬币个数*/
public class MinCoinNumer {

	public static int  minCoinNumber(int[] coins, int amount) {
		if(coins.length<=0 || amount<=0)
			return 0;
		int[] dp=new int[amount+1];
		Arrays.fill(dp, amount+1);//用amount+1填充数组初始化
		Arrays.sort(coins);//排序
		for(int i=1;i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				//正好满足，也就是需要最少为1张,更新dp[i]
				if(i-coins[j]==0)
					dp[i]=1;
				else if(i-coins[j]>0){
					//如果不满足，返回i-coins[j]所需要的最少张数+1,更新dp[i]
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
				}
				else {
					break;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(i+" "+dp[i]);
		}
		return dp[amount]>amount?-1:dp[amount];	
	}
	
	
	public static void main(String[] args) {
		int[] coins= {1,2,5,7};
		System.out.println(minCoinNumber(coins, 80));
	}

}
