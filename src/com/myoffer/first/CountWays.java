package com.myoffer.first;

public class CountWays {

	// �����ݹ鷨
	public static int countWays(int[] penny, int n, int aim) {
		if (n <= 0 || aim > 1000 || aim <= 0) {
			return 0;
		}
		return findMethodNum(penny, 0, aim);
	}

	private static int findMethodNum(int[] penny, int index, int aim) {
		// �ҵ�һ�ַ���
		if (aim == 0)
			return 1;
		// û���ҵ�����
		if (index == penny.length)
			return 0;
		int res = 0;// �ܵķ�����
		int k = aim / penny[index];// �����Ҫ������penny[index]Ԫ�������һ�aim
		for (int i = 0; i <= k; i++) {
			res = res + findMethodNum(penny, index + 1, aim - penny[index] * i);
		}
		return res;
	}
	//��̬�滮
	public static int countWays2(int[] penny,int n,int aim) {
		if(n<=0 || aim<=0) {
			return 0;
		}
		int[][] dp=new int[n][aim+1];
		//��ʼ��
		for(int i=0;i<n;i++)
			dp[i][0]=1;
		//��ʼ������ʾ���j�ǻ���penny[0]��������
		for(int j=1;j<aim+1;j++)
			dp[0][j]=j%penny[0]==0?1:0;
		//��arr[1]��ʼ
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
				//dp[i][j]��ʾ��ɽ��j�Ļ���arr[:i]�ķ�����
				dp[i][j]=count;
			}
			
		}
		return dp[n-1][aim];
	}

	
	public static void main(String[] args) {
		//����
		int[] coins= {1,2,5};
		int aim=11;
		System.out.println(countWays2(coins, 3, aim));
	}

}
