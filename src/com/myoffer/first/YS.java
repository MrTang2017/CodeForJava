package com.myoffer.first;

import java.util.Scanner;

public class YS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 勇士个数
		int k = sc.nextInt();// 技能个数
		int m = sc.nextInt();// 先知个数
		if (m >= n) {
			System.out.println(k);
		} else {
			if (n % 2 == 0)
				System.out.println(k * 2);
			else
				System.out.println(n - m + k);
		}
		sc.close();
	}

}
