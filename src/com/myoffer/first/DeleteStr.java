package com.myoffer.first;
/**
 * 给定一组字符串,判断是否字符串之间为亲密字符串
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeleteStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = new ArrayList<>();
		while (n-->0) {
			list.add(sc.next());
		}
		for (int j = 0; j < list.size(); j++) {
			for (int k = j + 1; k < list.size(); k++) {
				//长度不相等跳过
				if (list.get(j).length() != list.get(k).length())
					continue;
				if (isAnargms(list.get(j), list.get(k))) {
					list.remove(list.get(k));
					k--;
				}
			}

		}
		Collections.sort(list);
		for (String s : list)
			System.out.println(s);

		sc.close();
	}
	private static boolean isAnargms(String str1, String str2) {
		//判断两个乱序的字符串是否相等
		char[] chars1=str1.toCharArray();
		Arrays.sort(chars1);
		String sorteSt1=new String(chars1);
		char[] chars2=str2.toCharArray();
		Arrays.sort(chars2);
		String sorteSt2=new String(chars2);	
		return sorteSt1.equals(sorteSt2);
	}
}
