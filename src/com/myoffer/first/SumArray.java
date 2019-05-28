package com.myoffer.first;

import java.util.Scanner;

public class SumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		while(true) {
			double sum=0;
			int n=input.nextInt();
			int m=input.nextInt();
			double next=0;
			next=n;
			while(m>0) {
				sum=sum+next;
				next=Math.sqrt(next);
				m--;
			}
			System.out.println(Double.parseDouble(String.format("%.2f", sum)));
			;
		}
	}

}
