package com.array;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MaxAverageNumber {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] nums=new int[n];
		while(n-->0) {
			nums[n]=in.nextInt();
		}
		Arrays.sort(nums);
		double preAverage=nums[0];		
		in.close();
		double curAverage=preAverage;
		for(int i=1;i<nums.length;i++) {
			curAverage=(preAverage+nums[i])/2.0;
			System.out.println(curAverage);
			preAverage=curAverage;			
		}
		NumberFormat nFormat=NumberFormat.getInstance();
		nFormat.setMinimumFractionDigits(4);
		System.out.println(nFormat.format(curAverage));
	}

}
