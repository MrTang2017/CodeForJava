package com.myoffer.first;

/**
 * 给定一个只包含整数的有序数组， 每个元素都会出现两次， 唯有一个数只会出现一次，找出这个数。
 * 
 * @author 汤吉
 *
 */
public class SingleNonDuplicate {

	public static int singleNonDuplicate(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1])
				l = mid + 2;
			else
				r = mid;
		}
		return nums[l];

	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		System.out.println(singleNonDuplicate(nums));
	}

}
