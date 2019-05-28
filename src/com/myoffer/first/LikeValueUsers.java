package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LikeValueUsers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>(n);
		int i = 1;
		while (n > 0) {
			int value = in.nextInt();
			if (!map.containsKey(value)) {
				List<Integer> list = new ArrayList<>();
				list.add(i++);
				map.put(value, list);
			} else {
				map.get(value).add(i);
			}
			n--;
		}
		int q = in.nextInt();
		int count = 0;
		for (int j = 0; j < q; j++) {
			count = 0;
			int l = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
			List<Integer> list1 = map.get(k);
			for (Integer user : list1) {
				if (user >= l && user <= r) {
					count++;
				}
			}
			System.out.println(count);
		}
		in.close();
	}

}
