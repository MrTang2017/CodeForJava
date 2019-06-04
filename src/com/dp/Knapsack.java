package com.dp;

/**
 * 0-1��������
 * ��̬�滮���
 * @author ����
 *
 */
public class Knapsack {
	
	public static int knapsack(int totalValue,int[] prices,int[] hotVals) {
		int[] a=new int[prices.length+1];
		int[] b=new int[prices.length+1];
		for(int i=1;i<a.length;i++) {
			a[i]=prices[i-1];
		}
		for(int j=1;j<b.length;j++) {
			b[j]=hotVals[j-1];
		}
		
		int[][] dp=new int[a.length][totalValue+1];
		for(int i=1;i<a.length;i++) {
			for(int j=1;j<totalValue+1;j++) {
				//��ǰ���С����Ʒ�۸񣬲�����ǰi-1����Ʒ���ȶ��ܺ�һ��
				if (j<a[i]) {
					dp[i][j]=dp[i-1][j];
				}
				//�������ѡһ��
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-a[i]]+b[i]);
				}
			}
		}
		
		return dp[a.length-1][totalValue];			
	}

	public static void main(String[] args) {
		
		int[] prices= {200,600,100,180,300,450};
		int[] hotvalues= {6,10,3,4,5,8};
		System.out.println(knapsack(1000, prices, hotvalues));
		
	}

}
