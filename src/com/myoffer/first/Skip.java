package com.myoffer.first;

import java.util.Scanner;

public class Skip {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			int count = 0;
			while (n != 1) {
				if (n % 2 == 0)
					n = n / 2;
				else
					n = 3 * n + 1;
				count += 1;
				if (count>1000) {
					count=-1;
					break;
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

}
