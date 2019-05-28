package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubString {
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		while (n-- > 0) {
			list.add(sc.nextLine());
		}
		String tStr = sc.nextLine();
		int result = maxNumber(tStr, 0, 1);
		System.out.println(result);
		sc.close();
	}

	private static int maxNumber(String str, int start, int end) {
		if (start >= end || end>str.length())
			return 0;
		if (list.contains(str.substring(start, end))) {
			System.out.println("°üº¬");
			System.out.println(str.substring(start, end));
			if(end>str.length())
				return 0;
			return 1 + maxNumber(str.substring(end,str.length()), start, end);
		}
		System.out.println("²»°üº¬");
		if(end>str.length()) {
			return 0;
		}
		return maxNumber(str, start, end + 1) + maxNumber(str.substring(end+1,str.length()), start, end);
	}

}
