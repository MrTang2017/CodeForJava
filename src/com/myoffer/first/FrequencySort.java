package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

	public static String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}

		@SuppressWarnings("unchecked")
		List<Character>[] buckets = new ArrayList[s.length() + 1];
		StringBuilder sb = new StringBuilder();
		for (char c : map.keySet()) {
			int count = map.get(c);
			if (buckets[count] == null) {
				buckets[count] = new ArrayList<>();
			}
			buckets[count].add(c);
		}

		for (int j = buckets.length - 1; j >= 0; j--) {
			if (buckets[j] != null) {
				int k = j;
				for (char c1 : buckets[j]) {
					while (k-- > 0) {
						sb.append(c1);
					}
					k = j;
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String string = "tree";
		System.out.println(frequencySort(string));
	}

}
