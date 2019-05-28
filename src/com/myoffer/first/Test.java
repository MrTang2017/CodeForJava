package com.myoffer.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<String> list = new ArrayList<>();
		String[] strings =new String[n];
		int k=0;
		while(n>0) {
			strings[k++]=scanner.next();
			n--;
		}
		for (int i = 0; i < strings.length; i++) {
			int m = strings[i].length();
			int beginIndex = 0;
			while (m >= 8) {
				list.add(strings[i].substring(beginIndex, beginIndex + 8));
				beginIndex = beginIndex + 8;
				m = m - 8;
			}
			if (m < 8) {
				StringBuffer sBuffer = new StringBuffer(strings[i].substring(beginIndex, strings[i].length()));
				for (int j = 1; j <= 8 - (strings[i].length() - beginIndex); j++) {
					sBuffer.append("0");
				}
				list.add(sBuffer.toString());
			}
		}
		
		Collections.sort(list);
		for(String s:list) {
			System.out.print(s+" ");
		}
		scanner.close();

	}

}
