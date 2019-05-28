package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SwapStringLength {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String str = in.next();
		int op = in.nextInt();
		int length = str.length();
		Map<Character, List<Integer>> map = new HashMap<>();
		int max = 1;// ×î´óÖµ
		for (int i = 0; i < length; i++) {
			if (!map.containsKey(str.charAt(i))) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(str.charAt(i), list);
			} else {
				map.get(str.charAt(i)).add(i);
			}
		}
		for (Character c : map.keySet()) {
			List<Integer> list = map.get(c);
			if (list.size() < 2)
				continue;
			int size = list.size();
			int res = 1;
			int[][] dp = new int[size][size];
			for (int len = 2; len <= size; ++len) {
				for (int i = 0; i + len - 1 < size; i++) {
					dp[i][i + len - 1] = dp[i + 1][i + len - 2] + list.get(i + len - 1) - list.get(i) - len + 1;
					if (dp[i][i + len - 1] <= op)
						res = len;
				}
			}
			max=Math.min(max, res);
		}
		in.close();
		System.out.println(max);
	}

}
