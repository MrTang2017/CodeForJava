package com.myoffer.first;

import java.util.Arrays;
import java.util.Scanner;

public class MinCutCakeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] cakes = new int[n];
		for (int i = 0; i < n; i++) {
			cakes[i] = sc.nextInt();
		}
		Arrays.sort(cakes);
		int count = 0;
		int max = 0;
		int sum = 0;
		int mark = 0;
		int i = 0;
		boolean isUpdate = false;
		while (i < n - 1) {
			if ((sum = isLessK(cakes[i], cakes, k)) != 0) {
				if (sum > max) {
					max = sum;
					mark = cakes[i];
				}
			}
			if (i == n - 2) {
				update(cakes, mark);
				isUpdate = true;
				count += 1;
				max = 0;
				i = 0;
			}
			if (isUpdate == true && isSameHeight(cakes)) {
				break;
			}
			i = i + 1;
		}
		System.out.println(count);
		sc.close();
	}

	private static void update(int[] cakes, int m) {
		for (int i = 0; i < cakes.length; i++) {
			if (cakes[i] > m) {
				cakes[i] = m;
			}
		}
	}

	private static boolean isSameHeight(int[] cakes) {
		for (int i = 0; i < cakes.length - 1; i++) {
			if (cakes[i] != cakes[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static int isLessK(int mid, int[] cakes, int k) {
		int sum = 0;
		for (int i = 0; i < cakes.length; i++) {
			if (cakes[i] <= mid)
				continue;
			else {
				sum += cakes[i] - mid;
				if (sum > k)
					return 0;
			}
		}
		return sum;
	}
}
