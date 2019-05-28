package com.myoffer.first;

/**
 * ��ָOffer������3���������ظ�������
 * 
 * @author ����
 *
 */
public class JudgeDuplicate {

	/**
	 * �ж������Ƿ����ظ�����
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
				// ��������
				int temp = a[i];
				a[i] = a[a[i]];
				a[temp] = temp;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// ��ʼ��һ������
		int[] a = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(duplicate(a));
	}

}
