package com.myoffer.first;

import java.util.Arrays;
import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int i = 0;
		int max = 0;// 最大值
		while (N-- > 0) {
			num[i] = sc.nextInt();
			if (num[i] > max)
				max = num[i];
			i++;
		}
		int[] indexs = new int[max + 1];// 记录索引
		for (int j = 0; j < num.length; j++) {
			indexs[num[j]] = j;
		}
		Arrays.sort(num); // 排序
		int len = num.length;
		int rightMax = num[len - 1] + num[len - 2] - 1;
		int leftMax = num[len - 1] + num[len - 2] - len + 1;
		int maxValue = 0;
		for (int k = len-1; k >= 0; k--) {
			for (int s = k - 1; s >= 0; s--) {
				int cur = num[k] + num[s] - Math.abs(indexs[num[k]] - indexs[num[s]]);
				if (cur >= leftMax && cur <= rightMax) {
					if (cur > maxValue)
						maxValue = cur;
				} else {
					break;
				}
			}
		}

		System.out.println(maxValue);

		sc.close();
	}
}