package com.myoffer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxValue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<List<Integer>> list = new ArrayList<>();
		while (in.hasNext()) {
			int n = in.nextInt();
			int lenA = in.nextInt();// 集合A的大小
			int lenB = in.nextInt();// 集合B的大小
			String lineData = null;
			try {
				lineData = new BufferedReader(new InputStreamReader(System.in)).readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] data = lineData.split(" ");
			int[] item = new int[n];// 存储元素
			for (int i = 0; i < data.length; i++) {
				item[i] = Integer.parseInt(data[i]);
			}
			int minVal = lenA < lenB ? lenA : lenB;
			int max = 0;// 保存最大值
			for (int i = 0; i <= (n - minVal); i++) {
				for (int j = i + 1; j < n; j++) {
					List<Integer> list2 = new ArrayList<>();
					int sum1 = item[i];
					int[] a = Arrays.copyOfRange(item, j, j + minVal - 1);
					for (int k : a)
						sum1 = sum1 + k;
					if (sum1 >= max) {
						max = sum1;
						list2.add(i);
						for (int k = j; k < j + minVal - 1; k++) {
							list2.add(k);
						}
						list.add(list2);
					}
				}
			}
			for (int i = 0; i < list.size(); i++) {
				List<Integer> list2 = list.get(i);
				int sum3 = 0;
				for (int k : list2)
					sum3 += item[k];
				if (sum3 != max)
					list.remove(i);
			}
			List<Integer> list3 = list.get(0);
			for (int i = 0; i < item.length; i++) {
				if (list3.contains(i))
					System.out.print(1);
				else
					System.out.print(2);
			}
		}
		in.close();
	}

}
