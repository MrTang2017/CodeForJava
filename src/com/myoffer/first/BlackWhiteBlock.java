package com.myoffer.first;

/**
 * �ֽ���������Ӫ�ڶ��α��Ա�̵�һ��
 * �ݹ����������
 */
import java.util.Scanner;

public class BlackWhiteBlock {

	static int cl = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt();// ��ɫ
		int b = scanner.nextInt();// ��ɫ
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
