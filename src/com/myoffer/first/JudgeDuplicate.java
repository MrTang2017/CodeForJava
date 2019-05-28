package com.myoffer.first;

/**
 * 剑指Offer面试题3：数组中重复的数字
 * 
 * @author 汤吉
 *
 */
public class JudgeDuplicate {

	/**
	 * 判断数组是否有重复的数
	 * 
	 * @param a
	 * @param length
	 * @param c
	 * @return
	 */
	private static boolean duplicate(int[] a) {
		if (a.length <= 0) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] > a.length - 1 || a[i] < 0) {
				return false;
			}
		}

		for (int i = 0; i < a.length; i++) {
			while (a[i] != i) {
				if (a[i] == a[a[i]]) {
					return true;
				}
				// 交换数字
				int temp = a[i];
				a[i] = a[a[i]];
				a[temp] = temp;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// 初始化一个数组
		int[] a = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(duplicate(a));
	}

}
