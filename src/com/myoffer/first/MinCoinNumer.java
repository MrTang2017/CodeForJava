package com.myoffer.first;

import java.util.Arrays;

/*������ͬ����Ӳ��coins��һ���ܽ���дһ�º���������
���Դճ��ܽ���������ٵ�Ӳ�Ҹ���*/
public class MinCoinNumer {

	public static int  minCoinNumber(int[] coins, int amount) {
		if(coins.length<=0 || amount<=0)
			return 0;
		int[] dp=new int[amount+1];
		Arrays.fill(dp, amount+1);//��amount+1��������ʼ��
		Arrays.sort(coins);//����
		for(int i=1;i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				//�������㣬Ҳ������Ҫ����Ϊ1��,����dp[i]
				if(i-coins[j]==0)
					dp[i]=1;
				else if(i-coins[j]>0){
					//��������㣬����i-coins[j]����Ҫ����������+1,����dp[i]
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
