package com.dp;


/**
 * ����һ�������� n��������Ϊ���������������ĺͣ�
 * ��ʹ��Щ�����ĳ˻���󻯡� 
 * ��������Ի�õ����˻���
 * @author ����
 *
 */
public class IntegerBreak {
	/**
	 * ��̬�滮
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
	 * ̰���㷨��
	 * n>=5,�ȷָ��Ϊ3����ʣ�µĳ���Ϊ4ʱ����Ϊ2������Ϊ2�Ķ�
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
		//�˴�Ϊ�ָ�2������Ϊ2�Ķ�
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
