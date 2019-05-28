package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ô²È¦×îºóÊ£ÓàµÄÊı×Ö
 * @author ÌÀ¼ª
 *
 */
public class CircleFinalNumber {

	public static int circleFinalNumber(int n,int m) {
		
		List<Integer> list=new ArrayList<>();
		for (int i=1;i<=n;i++)
			list.add(i);
		int length=list.size();
		int key=0;
		while(length>1) {
			key=(key+m-1)%length;
			if(list.size()==2)
				System.out.print(list.get(key));
			else
				System.out.print(list.get(key)+" ");
			list.remove(key);
			length--;
		}	
		System.out.println();
		return list.get(0);	
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		if (n == 1) {
			System.out.print(1);
			System.out.println();
			System.out.println(0);
		} else {
			int result = circleFinalNumber(n, m);
			System.out.println(result);
			scanner.close();
		}

	}

}
