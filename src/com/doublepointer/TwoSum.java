package com.doublepointer;

public class TwoSum {

	
	public int[] twoSum(int[] nums,int target) {
		
		int i=0,j=nums.length-1;
		while(i<j) {
			int sum=nums[i]+nums[j];
			
			if (sum==target) {
				return new int[] {i+1,j+1};
			}
			if (sum>target) {
				j--;
			}
			else {
				i++;
			}
			
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {

		int[] nums = { 2, 7, 12, 14 };
		int target = 9;
		int[] result = new TwoSum().twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
