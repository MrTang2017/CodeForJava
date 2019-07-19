package com.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����������������������������ƽ���� 
 * ����12=4+4+4 13=4+9
 * 
 * @author ����
 *
 */
public class MinSqureNumber {

	/**
	 * dp�㷨��
	 * 
	 * @param n
	 * @return
	 */
	public static int minSqureNumber(int n) {

		if (n <= 0) {
			return 0;
		}
		// �ۻ���i��������ȫƽ������
		int[] dp = new int[n + 1];
		// ��ʼ��
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			// ����ÿ��i,�������ǣ�i-j*j)�Լ�һ����ȫƽ����j*j�ĺ�
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}

		}
		return dp[n];
	}

	/**
	 * ��̬��̬�滮
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
