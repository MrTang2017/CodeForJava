package com.myoffer.first;

/**
 * 最长不含重复字符的子字符串
 * 
 * @author 汤吉
 *
 */

public class LongSubStringLengthWithoutDup {

	public static int longSubStringLengthWithoutDup(String str) {
		// 保存每个字符结尾的最长子字符串长度
		/*
		 * int[] longest = new int[str.length()]; longest[0] = 1;
		 */
		int curLength = 1;
		int maxLength = 0;
		for (int i = 1; i < str.length(); i++) {
			int postion = -1;// 当前字符最近重复的位置
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
