package com.myoffer.first;

import java.util.Scanner;

public class MaxRopeLength2 {

	public static double findMaxlength(int[] lens, double maxRight, int m) {
		if (isMaxlength(lens, maxRight, m)) {
			return maxRight;
		}
		double left = 0;
		double right = maxRight;
		double max = 0;
		double k = 0;
		while (left < right) {
			double mid = (left + right) / 2;
			if (isMaxlength(lens, mid, m)) {
				if (m * mid > max) {
					max = m * mid;
					k = mid;
				}
				left = mid + 0.0001;
			} else {
				right = mid - 0.0001;
			}
		}
		return k;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] len = new int[n];
		int i = 0;
		int sum = 0;
		while (i < n) {
			len[i++] = sc.nextInt();
			sum += len[i - 1];
		}
		double maxlength = sum / m;// 取到的最大长度
		double result = findMaxlength(len, maxlength, m);
		System.out.println(Double.parseDouble(String.format("%.2f", result)));
		sc.close();
	}

	private static boolean isMaxlength(int[] lens, double maxlength, int m) {
		int sum = 0;
		for (int i = 0; i < lens.length; i++) {
			sum += lens[i] / maxlength;
		}
		if (sum >= m) {
			return true;
		}
		return false;
	}
}
