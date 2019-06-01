package com.myoffer.first;

/**
 * 字节跳动夏令营第二次笔试编程第一题
 * 递归求解立方块
 */
import java.util.Scanner;

public class BlackWhiteBlock {

	static int cl = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt();// 白色
		int b = scanner.nextInt();// 黑色
		int maxHeight = Math.min(w, b);
		int he = 0;
		while (maxHeight > 0) {
			if (isExist(maxHeight, w, b)) {
				he = maxHeight;
				break;
			}
			maxHeight--;
		}
		System.out.println(he + " " + cl);
		scanner.close();

	}

	private static boolean isExist(int maxHeight, int w, int b) {
		int firstfloor = maxHeight;
		if (firstfloor == 0)
			cl++;
		if (firstfloor >= 1) {
			if (w >= firstfloor)
				isExist(firstfloor - 1, w - firstfloor, b);
			if (b >= firstfloor)
				isExist(firstfloor - 1, w, b - firstfloor);
			firstfloor--;
		}
		return true;
	}
}
