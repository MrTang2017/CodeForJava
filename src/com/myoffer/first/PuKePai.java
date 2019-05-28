package com.myoffer.first;

import java.util.ArrayList;
import java.util.Scanner;

public class PuKePai {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		int i = 0;
		int num[]=new int[14];
		while (i < 6) {
			int n=sc.nextInt();
			num[n]=num[n]++;
			if (i >= 3) {
				sum2 += n;
			} else {
				
				sum1 += n;
			}
			i++;
		}
		int allCount=13;
		ArrayList<Integer> list=new ArrayList<>();
		for(int i1=1;i1<num.length;i1++) {
			if(num[i1]==4) {
				allCount=12;
			}	
			if(num[i1]==3)
				list.add(i1);		
		}
		int count = 0;
		for (int j = 1; j <= 13; j++) {
			for (int k = 1; k <= 13; k++) {
				if(num[j]==4)
					break;
				if (num[k]==4) {
					continue;
				}
				if(num[j]==3 && k==j) {
					continue;
				}
				if (sum1 + j > sum2 + k) {
					count++;
				}
			}
		}
		sc.close();
		double res =0;
		if (list.size()==0) {
			if (allCount==13) {
				res=(count * 1.0) / (13 * 13);
			}
			if (allCount==12) {
				res=(count * 1.0) / (12 * 12);
			}
		}
		else {
				res=(count * 1.0) / (13 * 12);
		}
		
		System.out.println(Double.parseDouble(String.format("%.4f", res)));
	}

}
