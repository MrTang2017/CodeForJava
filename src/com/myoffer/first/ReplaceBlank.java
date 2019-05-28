package com.myoffer.first;

public class ReplaceBlank {

	public static void main(String[] args) {
		String string = "we are happy!";
		String[] strings = string.split("");
		int count=0;
		for (String s : strings) {
			if (s.equals(" ")) {
				count+=1;
			}
		}
		
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals(" ")) {
				strings[i]="%20";
			}
		}
		System.out.println(count);
		for (String s1 : strings) {
			System.out.print(s1);
		}
		System.out.println();
		String string2 = string.replace(" ", "%20");
		System.out.println(string2);

	}

}
