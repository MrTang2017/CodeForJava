package com.dp;

public class SumRange {

	private static int[] sums;
	public static void numArray(int[] nums) {
		sums=new int[nums.length+1];
		for(int i=1;i<=nums.length;i++) {
			//sums[i]的值存的是0~i-1的和
			sums[i]=sums[i-1]+nums[i-1];
		}	
	}
	
	public static int sumRange(int i,int j) {
		return sums[j+1]-sums[i];
	}
	
	
	public static void main(String[] args) {
		int[] nums= {-2, 0, 3, -5, 2, -1};
		numArray(nums);
		System.out.println(sumRange(0, 5));

	}

}
