package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * �ֽ������ڶ��⣬�����ַ�����ȷ��
 * ���磬����helllo,���hello
 * ����helloo,���hello
 * ����wooooooow,���woow
 * @author ����
 *
 */
public class DetectString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while ((N--) > 0) {
			String str = sc.next();
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}
			int i = 0;
			while (i < list.size() - 1) {
				if ((list.get(i) == list.get(i+1))
						&& (i + 2 < list.size() && list.get(i + 1) == list.get(i + 2)))
					list.remove(list.get(i));
				else if ((list.get(i) == list.get(i + 1))
						&& (i + 2 < list.size() && list.get(i + 1) != list.get(i + 2))
						&& (i + 3 < list.size() && list.get(i + 2) == list.get(i + 3)))
					list.remove(list.get(i + 2));
				else
					i++;
			}
			for (Character c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
		sc.close();
	}

}
