package com.myoffer.first;

import java.util.Scanner;

public class CoinsRolate {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println(n + " " + 0);
			int x = n;
			int y = m;
			resultA(n, m, x, y);
		}
		scanner.close();
	}

	private static void resultA(int n, int m, int x, int y) {
		int left=x-y;
		while(left!=0) {
			System.out.println(left+" "+y);
			if(left<y) {
				resultA(n, m, x, 2*left+y-m);
			}
			else {
				resultA(n, m, x, m-y);			
			}
			
		}
		System.out.println(0+" "+n);
	}

}
