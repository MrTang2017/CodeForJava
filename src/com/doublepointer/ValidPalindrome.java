package com.doublepointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。 判断是否能成为回文字符串
 * 
 * @author 汤吉
 *
 */
public class ValidPalindrome {

	public boolean validPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPaildRome(s, i, j - 1) || isPaildRome(s, i + 1, j);

			}

		}
		return true;

	}

	private boolean isPaildRome(String s, int i, int j) {
		
		while(i<j) {
			if (s.charAt(i++)!=s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * public boolean validPalindrome(String s) { int i=0,j=s.length(); if
	 * (isPalindRome(s,i,j)) { return true; }
	 * 
	 * while(i<j) { if (deleteC(s,i,j)) { return true; } j--;
	 * 
	 * }
	 * 
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * private boolean deleteC(String s, int i, int j) { String preStr=""; if (j>1)
	 * { preStr=s.substring(i, j-1); } String postStr=""; if (j<s.length()) {
	 * postStr=s.substring(j,s.length()); } String str=new
	 * StringBuilder(preStr+postStr).reverse().toString(); return
	 * (preStr+postStr).equals(str); }
	 * 
	 * private boolean isPalindRome(String s, int i, int j) { String newStr=new
	 * StringBuilder(s.substring(i, j)).reverse().toString(); return
	 * s.equals(newStr); }
	 */
	public static void main(String[] args) {

		System.out.println(new ValidPalindrome().validPalindrome("abca"));

	}

}
