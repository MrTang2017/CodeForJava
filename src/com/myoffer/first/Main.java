package com.myoffer.first;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int k = in.nextInt();
			if (x > y) {
				int t = x;
				x = y;
				y = t;
			}
			if (k < y) {
				System.out.println(-1);
			} else {
				if ((y - x) % 2 != 0) {
					System.out.println(k - 1);
				} else if ((k - x) % 2 == 0) {
					System.out.println(k);
				} else {
					System.out.println(k - 2);
				}
			}

		}
		in.close();

	}
}
