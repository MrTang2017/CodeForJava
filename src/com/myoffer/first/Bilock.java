package com.myoffer.first;

import java.util.Scanner;

public class Bilock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] num = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				num[i][j] = scanner.nextInt();
			}
		}

		boolean[] flag = new boolean[M * N];
		int k = 0, s = 0;
		int count = 0;
		while (k < N) {
			while (s < M) {
				int index = k * N + s;
				if (num[k][s] == 1) {
					if (isBlock(k, s, num, flag, N, M)) {
						count++;
						flag[index] = true;
					}
				}
				s++;
			}
			s=0;
			k++;
		}

		System.out.println(count);
		scanner.close();

	}

	private static boolean isBlock(int k, int s, int[][] num, boolean[] flag, int N, int M) {
		boolean isBlock = false;
		
		//ÅÐ¶ÏÓÒ
		if (s + 1 < M && num[k][s + 1] == 1 && !flag[k * M+ s + 1]) {
			flag[k * M + s + 1] = true;
			isBlock = true;
		}
		//ÅÐ¶ÏÏÂ
		if (k + 1 < N && num[k + 1][s] == 1 && !flag[(k + 1) * M + s]) {
			flag[(k + 1) * M + s] = true;
			isBlock = true;
		}
		//ÅÐ¶ÏÓÒÏÂ¶Ô½Ç
		if (k + 1 < N && s + 1 < N && num[k + 1][s + 1] == 1 && !flag[(k + 1) * M + s + 1]) {
			flag[(k + 1) * M + s + 1] = true;
			isBlock = true;
		}
		//ÅÐ¶Ï×óÏÂ¶Ô½Ç
		if (k + 1 < N && s - 1 >= 0 && num[k + 1][s - 1] == 1 && !flag[(k + 1) * M + s - 1]) {
			flag[(k + 1) * M + s - 1] = true;
			isBlock = true;
		}
		//ÅÐ¶Ï×ó
		if (s - 1 >= 0 && !flag[k * M + s - 1] && num[k][s - 1] == 1) {
			flag[k * M + s - 1] = true;
			isBlock = true;
		}
		//ÅÐ¶Ï×óÉÏ¶Ô½Ç
		if (k - 1 >= 0 && s - 1 >= 0 && !flag[(k - 1) * M + s - 1] && num[k - 1][s-1] == 1) {
			flag[(k - 1) * M + s-1] = true;
			isBlock = true;
		}
		//ÅÐ¶ÏÉÏ
		if (k - 1 >= 0 && !flag[(k - 1) * M + s] && num[k - 1][s] == 1) {
			flag[(k - 1) * M + s] = true;
			isBlock = true;
		}
		//ÅÐ¶ÏÓÒÉÏ¶Ô½Ç
		if (k - 1 >= 0 && s + 1 < M && !flag[(k - 1) * M + s + 1] && num[k - 1][s + 1] == 1) {
			flag[(k - 1) * M + s + 1] = true;
			isBlock = true;
		}
		System.out.println(isBlock);
		return isBlock;
	}

}
