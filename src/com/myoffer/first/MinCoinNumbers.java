package com.myoffer.first;
/**
 * 字节跳动第一题，求硬币最少个数
 */
import java.util.Scanner;

public class MinCoinNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] coins = { 1, 4, 16, 64 };
		int m = 1024 - n;
		int count = 0;
		for (int i = coins.length - 1; i >= 0; i--) {
			int curNum = m / coins[i];
			if (curNum != 0) {
				m = m - curNum * coins[i];
			}
			count += curNum;
			if (m==0) {
				break;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
