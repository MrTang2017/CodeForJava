package com.dp;

public class UniquePaths {

	/**
	 * ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� )
	 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish���� ���ܹ��ж�������ͬ��·���� ʾ���� ����: m = 3,
	 * n = 2 ���: 3 ����: �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ� 1. ���� -> ���� -> ���� 2. ���� -> ���� -> ����
	 * 3. ���� -> ���� -> ����
	 * 
	 * @param args
	 */

	public static int uniquePaths(int m, int n) {
		int rows = n;
		int cols = m;

		int[][] dp = new int[rows][cols];
		for (int i = 0; i < cols; i++)
			dp[0][i] = 1;
		for (int j = 0; j < rows; j++)
			dp[j][0] = 1;
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[rows - 1][cols - 1];

	}

	public static void main(String[] args) {

		System.out.println(uniquePaths(3, 2));
	}

}
