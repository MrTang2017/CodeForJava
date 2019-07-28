package com.strs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p， 找到 s 中所有是 p 的字母异位词的子串， 返回这些子串的起始索引 输入: s: "abab" p:
 * "ab" 输出: [0, 1, 2]
 * 
 * @author 汤吉
 *
 */
public class FindAnagrams {

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> list2 = new ArrayList<>();
		char[] sc = s.toCharArray();
		char[] ps = p.toCharArray();
		int[] charNumberOfs = new int[26];
		int[] charNumberOfp = new int[26];
		for (int i = 0; i < p.length(); i++) {
			charNumberOfp[ps[i] - 'a']++;
		}
		for (int j = 0; j < s.length(); j++) {
			if (j >= p.length()) {
				charNumberOfs[sc[j - ps.length] - 'a']--;
			}
			charNumberOfs[sc[j] - 'a']++;
			if (Arrays.equals(charNumberOfs, charNumberOfp)) {
				list2.add(j - p.length() + 1);
			}
		}

		return list2;
	}
	

	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		List<Integer> list = new FindAnagrams().findAnagrams(s, p);
		System.out.println(list);
	}

}
