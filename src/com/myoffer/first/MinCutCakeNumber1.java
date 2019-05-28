package com.myoffer.first;

import java.util.Arrays;
import java.util.Scanner;

public class MinCutCakeNumber1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] cakes = new int[n];
		for (int i = 0; i < n; i++) {
			cakes[i] = sc.nextInt();
		}
		Arrays.sort(cakes);
		int sum=0;
		for (int i = 1; i < cakes.length; i++) {
			sum+=cakes[i]-cakes[0];
		}
		int ans=sum/k;
		if (sum%k!=0)
			ans+=1;
		sc.close();
		System.out.println(ans);


	}
	
/*	private static boolean isSameHeight(int[] cakes) {
		for (int i = 0; i < cakes.length - 1; i++) {
			if (cakes[i] != cakes[i + 1]) {
				return false;
			}
		}
		return true;
	}*/

	/*private static boolean isLessK(int mid, int[] cakes, int k) {
		int sum = 0;
		for (int i = 0; i < cakes.length; i++) {
			if (cakes[i] <= mid)
				continue;
			else {
				sum += cakes[i] - mid;
				if (sum>k)
					return false;
			}		
		}
		for (int i = 0; i < cakes.length; i++) {
			if (cakes[i]>mid) {
				cakes[i]=mid;
			}
		}
		return true;
	}*/

}
