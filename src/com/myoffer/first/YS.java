package com.myoffer.first;

import java.util.Scanner;

public class YS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// ��ʿ����
		int k = sc.nextInt();// ���ܸ���
		int m = sc.nextInt();// ��֪����
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
