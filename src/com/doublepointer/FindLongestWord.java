package com.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindLongestWord {

	public String findLongestWord(String s, List<String> d) {
		List<String> list=new ArrayList<>();
		int maxLen=0;
		String str="";
		for (String word : d) {
			if (isContain(s, word)) {
				if (word.length()>maxLen) {
					maxLen=word.length();
					str=word;
				}
				list.add(word);
				}
			}
		int len=str.length();
        for(String word:list) {
        	if (word.length()>=len && word.compareTo(str)<0) {
				len=word.length();
				str=word;
			}
        }
		return str;

	}
	@Test
	private boolean isContain(String s, String word) {
		int j = 0;
		for (int i = j; i < s.length() && j < word.length();) {
			if (s.charAt(i) == word.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}

		if (j >= word.length()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		String testStr = "abpcplea";
		String[] strings = { "apple", "abcea", "cjjhv", "plea" };
		List<String> list = Arrays.asList(strings);
		System.out.println(new FindLongestWord().findLongestWord(testStr, list));
	}

}
