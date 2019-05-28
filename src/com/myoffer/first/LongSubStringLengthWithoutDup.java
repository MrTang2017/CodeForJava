package com.myoffer.first;

/**
 * ������ظ��ַ������ַ���
 * 
 * @author ����
 *
 */

public class LongSubStringLengthWithoutDup {

	public static int longSubStringLengthWithoutDup(String str) {
		// ����ÿ���ַ���β������ַ�������
		/*
		 * int[] longest = new int[str.length()]; longest[0] = 1;
		 */
		int curLength = 1;
		int maxLength = 0;
		for (int i = 1; i < str.length(); i++) {
			int postion = -1;// ��ǰ�ַ�����ظ���λ��
			for (int j = 0; j < i; j++) {
				if (str.charAt(j) == str.charAt(i)) {
					postion = j;
				}
			}
			int length = i - postion;
			if (length > i) {
				curLength += 1;
			} else {
				if (length <= curLength)
					curLength = length;
				else
					curLength += 1;
			}
			if (curLength > maxLength) {
				maxLength = curLength;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {

		String string = "pwwkew";
		System.out.println(longSubStringLengthWithoutDup(string));

	}

}
