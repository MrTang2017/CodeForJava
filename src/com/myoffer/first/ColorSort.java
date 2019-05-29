package com.myoffer.first;

public class ColorSort {

	public static void sortColors(int[] nums) {
		int[] counts = new int[3];
		for (int i = 0; i < nums.length; i++) {
			counts[nums[i]]++;
		}
		for (int j = 0; j < 3; j++) {
			int k = counts[j];
			while (k-- > 0) {
				if (j == 2 && k == 0)
					System.out.print(j);
				else {
					System.out.print(j + ",");
				}
				
			}
		}
	}

	public static void main(String[] args) {
		int nums[]= {2,0,2,1,1,0};
		sortColors(nums);
	}

}
