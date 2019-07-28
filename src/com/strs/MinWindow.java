package com.strs;

import java.util.HashMap;
import java.util.Map;

/**
 * ��С�����Ӵ� ���룺ADOBECODEBANC ABC �����BANC
 * 
 * @author ����
 *
 */
public class MinWindow {

	public String minWindow(String s, String t) {
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		Map<Character, Integer> map1=new HashMap<>();
		Map<Character, Integer> map2=new HashMap<>();
		int left = 0, right = 0, minLen = Integer.MAX_VALUE;
		int start = 0;
		for (char c : c2) {
			if (!map2.containsKey(c)) {
				map2.put(c, 1);
			}
			else {
				map2.put(c, map2.get(c)+1);
			}
		}
		int match = 0;// ��¼ƥ����
		while (right < s.length()) {
			char c = c1[right];
			// s���ַ���t��
			if (map2.containsKey(c)) {
				if (!map1.containsKey(c)) {
					map1.put(c, 1);
				}
				else {
					map1.put(c, map1.get(c)+1);
				}
				if (map1.get(c) == map2.get(c)) {
					match+=1;
				}

			}
			// ƥ��ɹ�
			while (match == map2.size()) {

				if (right - left + 1 <minLen) {
					// ������С����λ�úͳ���
					start = left;
					minLen = right - start + 1;
				}
				char c3 = c1[left];
				if (map2.containsKey(c3)) {
					map1.put(c3, map1.get(c3)-1);
					if (map1.get(c3) < map2.get(c3)) {
						match-=1;
					}
				}
				left++;
			}

			right++;
		}

		return minLen == Integer.MAX_VALUE ? "": s.substring(start, minLen+start);
	}

	public static void main(String[] args) {
		String string = "acbbaca"; 
						
		String pString = "aba";
		System.out.println(new MinWindow().minWindow(string, pString));

	}

}
