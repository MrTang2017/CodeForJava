package com.myoffer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringJoin {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<String>();
		String[] numbers1 = null;
		String[] numbers2 = null;
		int m = 0;
		while (m < 2) {
			String number = bReader.readLine();
			if (m == 0) {
					numbers1 = number.split(",");
			} else {
					numbers2 = number.split(",");
			}
			m = m + 1;
		}
		bReader.close();
		int i = 0, j = 0;
		while (i < numbers1.length && j < numbers2.length) {
			if (numbers1.length - i < n)
				break;
			for (int k = 0; k < n; k++) {
				list.add(numbers1[i++]);
			}
			if (numbers2.length - j < n)
				break;
			for (int k = 0; k < n; k++) {
				list.add(numbers2[j++]);
			}
		}		
		if (i <= j) {
			while (i < numbers1.length)
				list.add(numbers1[i++]);
			while (j < numbers2.length)
				list.add(numbers2[j++]);
		} else {
			while (j < numbers2.length)
				list.add(numbers2[j++]);
			while (i < numbers1.length)
				list.add(numbers1[i++]);
		}
		for (int s = 0; s < list.size();s++) {
			if(list.get(s).equals(""))
				list.remove(s);	
		}
		for (int j2 = 0; j2 < list.size(); j2++) {
			if (j2==list.size()-1)
				System.out.print(Integer.parseInt(list.get(j2)));
			else
				System.out.print(Integer.parseInt(list.get(j2))+",");
		}
		
		sc.close();

	}

}
