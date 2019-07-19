package com.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {

	private final static HashSet<Character> vowels = new HashSet<>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {

		char[] strings = s.toCharArray();
		int i = 0, j = strings.length - 1;
		while (i < j) {
			if (!vowels.contains(strings[i])) {
				i++;
			} else if (!vowels.contains(strings[j])) {
				j--;
			} else {
				char temp = strings[i];
				strings[i] = strings[j];
				strings[j] = temp;
				i++;
				j--;
			}

		}

		return new String(strings);

	}

	public static void main(String[] args) {
		
		System.out.println(new ReverseVowels().reverseVowels("leetcode"));

	}

}
